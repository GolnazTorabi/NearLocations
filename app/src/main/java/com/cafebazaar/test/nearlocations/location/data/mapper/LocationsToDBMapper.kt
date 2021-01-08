package com.cafebazaar.test.nearlocations.location.data.mapper

import com.cafebazaar.test.nearlocations.location.data.response.Venue
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.utils.database.Mapper

class LocationsToDBMapper : Mapper<LocationData, Venue>() {
    override fun map(value: LocationData?): Venue {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: Venue?): LocationData? {
        return if (value == null) {
            null
        } else {
            LocationData(
                value.id,
                value.name,
                value.popularityByGeo,
                value.location,
                value.categories
            )
        }
    }
}