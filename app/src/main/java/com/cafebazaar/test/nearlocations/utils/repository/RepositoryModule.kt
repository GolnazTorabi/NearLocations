package com.cafebazaar.test.nearlocations.utils.repository

import com.cafebazaar.test.nearlocations.location.data.repository.LocationRepositoryImpl
import com.cafebazaar.test.nearlocations.location.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideLocationRepository(repo: LocationRepositoryImpl): LocationRepository = repo


}