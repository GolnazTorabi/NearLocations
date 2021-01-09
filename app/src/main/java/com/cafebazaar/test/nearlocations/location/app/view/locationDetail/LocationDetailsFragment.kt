package com.cafebazaar.test.nearlocations.location.app.view.locationDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cafebazaar.test.nearlocations.R
import com.cafebazaar.test.nearlocations.databinding.LocationDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class LocationDetailsFragment : Fragment() {

    private val disposables = CompositeDisposable()
    private var _binding: LocationDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: LocationDetailsFragmentArgs by navArgs()


    private val viewModel: LocationDetailsViewModel by viewModels()
    private val id by lazy {
        args.locationId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.location_details_fragment, container, false)
        _binding?.viewModel = viewModel
        _binding?.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLocationData()
        binding.back.setOnClickListener { activity?.onBackPressed() }
    }

    private fun getLocationData() {
        viewModel.getEpisodeDetail(id)
    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}