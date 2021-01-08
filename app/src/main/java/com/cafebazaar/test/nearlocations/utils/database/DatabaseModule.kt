package com.cafebazaar.test.nearlocations.utils.database

import android.content.Context
import androidx.room.Room
import com.cafebazaar.test.nearlocations.location.data.database.LocationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "APP-DATA.db"
        ).allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideCharacterDao(database: AppDatabase): LocationDao {
        return database.locationDao()
    }


}