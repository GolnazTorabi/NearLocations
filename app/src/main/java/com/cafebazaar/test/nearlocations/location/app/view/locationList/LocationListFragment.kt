package com.cafebazaar.test.nearlocations.location.app.view.locationList

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafebazaar.test.nearlocations.R
import com.cafebazaar.test.nearlocations.databinding.LocationListFragmentBinding
import com.cafebazaar.test.nearlocations.location.app.view.locationList.adapter.LocationListAdapter
import com.cafebazaar.test.nearlocations.utils.Dialog.AlertDialogCallback
import com.cafebazaar.test.nearlocations.utils.Dialog.CustomDialog
import com.cafebazaar.test.nearlocations.utils.database.SharedPreferences.MainPreferences
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.Disposable
import javax.inject.Inject


@AndroidEntryPoint
class LocationListFragment : Fragment() {

    private val viewModel: LocationListViewModel by viewModels()
    private var _binding: LocationListFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var adapter: LocationListAdapter
    private var subscribeLocation: Disposable? = null
    private var subscribeLoadMore: Disposable? = null

    companion object {
        private val MY_PERMISSIONS_REQUEST_LOCATION = 99
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var lat: Double? = 0.0
    private var lng: Double? = 0.0
    private var page: Int = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.location_list_fragment, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        binding.back.setOnClickListener { activity?.onBackPressed() }
        initAdapter()
        getLocationPermissionCheck()
    }

    private fun getLocationPermissionCheck() {
        if (checkPermission()) {
            getLocationLatLng()
            getLocations()
        } else {
            requestPermission()
        }
    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            MY_PERMISSIONS_REQUEST_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    showDenyDialog()
                } else {
                    getLocationLatLng()
                    getLocations()
                }
            }
        }
    }

    private fun getLocations() {
        viewModel.getLocations(
            lat,
            lng,
            MainPreferences.getInstance(requireContext()).getLat(0.0),
            MainPreferences.getInstance(requireContext()).getLng(0.0)
        )
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(viewLifecycleOwner, Observer {
            adapter.fillData(it.toMutableList())
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "Unfortunately, there is a problem.", Toast.LENGTH_LONG).show()
        })
    }


    private fun getLocationLatLng() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (lat == 0.0 || lng == 0.0) {
                        lat = location?.latitude
                        lng = location?.longitude
                    }
                }
        }
    }

    private fun showDenyDialog() {
        val callback = object : AlertDialogCallback {
            override fun onPositive() {
                getLocationPermissionCheck()
            }

            override fun onNegative() {

            }
        }
        val tt = CustomDialog(
            requireActivity(), callback,
            "در صورت عدم دسترسی امکان مشاهده مکان های نزدیک شما وجود ندارد.",
            "دادن دسترسی", "باشه"
        )
        tt.show()
    }


    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.list.layoutManager = layoutManager
        binding.list.adapter = adapter

        subscribeLocation = adapter.clickEventLocation
            .subscribe {
                val action =
                    LocationListFragmentDirections.actionLocationListFragmentToLocationDetailsFragment(
                        it.first?.locationId.toString()
                    )
                findNavController().navigate(action)
            }
        subscribeLoadMore = adapter.clickEventLoadMore
            .subscribe {
                page++
                viewModel.getLocations(
                    lat,
                    lng,
                    MainPreferences.getInstance(requireContext()).getLat(0.0),
                    MainPreferences.getInstance(requireContext()).getLng(0.0),
                    page,
                    it
                )
            }
    }

    override fun onPause() {
        super.onPause()
        lat?.let { it1 -> MainPreferences.getInstance(requireContext()).setLat(it1) }
        lng?.let { it1 -> MainPreferences.getInstance(requireContext()).setLng(it1) }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.list.adapter = null
        _binding = null
        subscribeLoadMore?.dispose()
        subscribeLocation?.dispose()
    }

}