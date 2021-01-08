package com.cafebazaar.test.nearlocations.location.domain.usecase

import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.repository.LocationRepository
import io.reactivex.Maybe
import javax.inject.Inject

class InsertLocationsToDatabaseUseCase  @Inject constructor(private val locationRepository: LocationRepository) {
    fun insertLocations(data: List<LocationData>): Maybe<List<Long>> {
        return locationRepository.insertAllLocation(data)
    }
}