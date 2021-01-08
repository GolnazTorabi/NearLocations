package com.cafebazaar.test.nearlocations.location.domain.repository

import com.cafebazaar.test.nearlocations.location.data.response.ResponseLocationsList
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import io.reactivex.Maybe
import io.reactivex.Single

interface LocationRepository {
    fun getNearLocations(latLang: String): Single<ResponseLocationsList>
    fun getNearLocationsFromDb(): Single<List<LocationData>>
    fun insertAllLocation(locationData: List<LocationData>): Maybe<List<Long>>
    fun getSpecificLocation(id: String): Maybe<LocationData>
    fun deleteAllLocations(): Single<Int>
}