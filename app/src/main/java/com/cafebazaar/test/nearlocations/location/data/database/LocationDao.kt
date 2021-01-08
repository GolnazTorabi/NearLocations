package com.cafebazaar.test.nearlocations.location.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import io.reactivex.Maybe
import io.reactivex.Single

interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLocation(locationData: List<LocationData>): Maybe<List<Long>>

    @Query("Select * From Locations Where locationId = :id")
    fun getSpecificLocation(id: String): Maybe<LocationData>

    @Query("DELETE FROM Locations")
    fun deleteAllLocations(): Single<Int>
}