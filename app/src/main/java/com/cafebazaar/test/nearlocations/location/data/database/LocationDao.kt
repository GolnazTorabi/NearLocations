package com.cafebazaar.test.nearlocations.location.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLocation(locationData: List<LocationData>): Maybe<List<Long>>

    @Query("Select * From Locations LIMIT:limit OFFSET:offset")
    fun getLocations(limit: Int, offset: Int): Single<List<LocationData>>

    @Query("Select * From Locations Where locationId = :id")
    fun getSpecificLocation(id: String): Maybe<LocationData>

    @Query("DELETE FROM Locations")
    fun deleteAllLocations(): Single<Int>
}