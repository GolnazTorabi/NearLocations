package com.cafebazaar.test.nearlocations.location.domain.usecase

import android.annotation.SuppressLint
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.repository.LocationRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    sealed class Result {
        data class Success(val locations: LocationData) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    @SuppressLint("CheckResult")
    fun getLocation(locationId: String): Observable<Result> {
        return locationRepository.getSpecificLocation(locationId)
            .toObservable()
            .map {
                Result.Success(it) as Result
            }
            .onErrorReturn { Result.Failure(it) }
    }

}
