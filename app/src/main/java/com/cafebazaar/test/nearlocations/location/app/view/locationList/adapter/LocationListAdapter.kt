package com.cafebazaar.test.nearlocations.location.app.view.locationList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cafebazaar.test.nearlocations.R
import com.cafebazaar.test.nearlocations.databinding.ItemLocationListBinding
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class LocationListAdapter @Inject constructor() :
    RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>() {
    private val clickSubjectLocation = PublishSubject.create<Pair<LocationData?, Int>>()
    private var items: MutableList<LocationData> = mutableListOf()

    private var layoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationListAdapter.LocationViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding: ItemLocationListBinding = DataBindingUtil.inflate(
            layoutInflater!!,
            R.layout.item_location_list,
            parent,
            false
        )
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.setData(items[position])
    }

    fun fillData(items: MutableList<LocationData>) {
        this.items = items
        notifyDataSetChanged()
    }

    val clickEventLocation: Observable<Pair<LocationData?, Int>> = clickSubjectLocation

    inner class LocationViewHolder(private val binding: ItemLocationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: LocationData) {
            binding.data = data
            clickSubjectLocation.onNext(Pair(data, layoutPosition))
        }
    }
}


