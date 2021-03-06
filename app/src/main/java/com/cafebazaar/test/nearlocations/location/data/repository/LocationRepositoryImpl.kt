package com.cafebazaar.test.nearlocations.location.data.repository

import com.cafebazaar.test.nearlocations.location.data.api.LocationApiImpl
import com.cafebazaar.test.nearlocations.location.data.database.LocationDao
import com.cafebazaar.test.nearlocations.location.data.response.ResponseLocationsList
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.repository.LocationRepository
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationApiImpl: LocationApiImpl,
    private val locationsDao: LocationDao
) : LocationRepository {
    override fun getNearLocations(latLang: String, page: Int?): Single<ResponseLocationsList> {
        return locationApiImpl.getLocations(latLang, page ?: 0)
    }

    override fun getNearLocationsFromDb(offset: Int): Single<List<LocationData>> {
        return locationsDao.getLocations(30, offset)
    }

    override fun insertAllLocation(locationData: List<LocationData>): Maybe<List<Long>> {
        return locationsDao.insertAllLocation(locationData)
    }

    override fun getSpecificLocation(id: String): Maybe<LocationData> {
        return locationsDao.getSpecificLocation(id)
    }

    override fun deleteAllLocations(): Single<Int> {
        return locationsDao.deleteAllLocations()
    }
}