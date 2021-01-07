package com.cafebazaar.test.nearlocations.location.app.view.locationList

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cafebazaar.test.nearlocations.R

class LocationListFragment : Fragment() {

    companion object {
        fun newInstance() =
            LocationListFragment()
    }

    private lateinit var viewModel: LocationListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.location_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            LocationListViewModel::class.java
        )
        // TODO: Use the ViewModel
    }

}