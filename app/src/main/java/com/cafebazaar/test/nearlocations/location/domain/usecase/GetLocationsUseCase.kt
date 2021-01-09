package com.cafebazaar.test.nearlocations.location.domain.usecase

import android.annotation.SuppressLint
import com.cafebazaar.test.nearlocations.location.data.mapper.LocationsToDBMapper
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.repository.LocationRepository
import com.cafebazaar.test.nearlocations.utils.math.Distance
import com.test.cleanArchRoomTest.utils.network.NetworkConnection
import io.reactivex.Observable
import javax.inject.Inject
import kotlin.math.abs

class GetLocationsUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    sealed class Result {
        object Loading : Result()
        data class Success(val locations: List<LocationData>) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    private fun getDistance(lat: Double?, lng: Double?, oldLat: Double?, oldLng: Double?): Double {
        return abs(
            Distance.distance(
                lat ?: 0.0,
                lng ?: 0.0,
                oldLat ?: 0.0,
                oldLng ?: 0.0
            )
        )
    }

    @SuppressLint("CheckResult")
    fun getLocationsList(
        lat: Double?,
        lng: Double?,
        oldLat: Double?,
        oldLng: Double?,
        page: Int,
        offset: Int
    ): Observable<Result> {
        return if (getDistance(
                lat,
                lng,
                oldLat,
                oldLng
            ) < 100.0 || !NetworkConnection.checkNetwork()
        ) {
            return locationRepository.getNearLocationsFromDb(offset)
                .toObservable()
                .map {
                    Result.Success(it) as Result
                }
                .onErrorReturn { Result.Failure(it) }
                .startWith(Result.Loading)
        } else {
            locationRepository.deleteAllLocations()
            val latLng = "$lat,$lng"
            locationRepository.getNearLocations(latLng, page)
                .toObservable()
                .map {
                    val data = LocationsToDBMapper().reverseMap(it.response?.groups?.get(0)?.items)
                    data?.let { it1 -> Result.Success(it1) } as Result
                }
                .onErrorReturn { Result.Failure(it) }
                .startWith(Result.Loading)
        }

    }
}