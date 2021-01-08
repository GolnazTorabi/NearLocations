package com.cafebazaar.test.nearlocations.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cafebazaar.test.nearlocations.location.data.database.LocationDao
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData

@Database(entities = [LocationData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}