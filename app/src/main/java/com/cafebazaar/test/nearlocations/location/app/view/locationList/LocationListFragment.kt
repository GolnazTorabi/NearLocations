package com.cafebazaar.test.nearlocations.location.app.view.locationList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cafebazaar.test.nearlocations.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationListFragment : Fragment() {

    private val viewModel : LocationListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.location_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}