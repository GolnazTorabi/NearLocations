package com.cafebazaar.test.nearlocations.location.data.api

import com.cafebazaar.test.nearlocations.location.data.response.ResponseLocationsList
import io.reactivex.Single
import javax.inject.Inject

class LocationApiImpl @Inject constructor(private val apiInterface: LocationApi) {
    fun getLocations(latLang: String, page: Int): Single<ResponseLocationsList> {
        return apiInterface.getNearLocations(latLang, page)
    }
}