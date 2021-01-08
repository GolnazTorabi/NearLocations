package com.cafebazaar.test.nearlocations.location.data.mapper

import com.cafebazaar.test.nearlocations.location.data.response.ItemsItem
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.utils.database.Mapper

class LocationsToDBMapper : Mapper<LocationData, ItemsItem>() {
    override fun map(value: LocationData?): ItemsItem {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ItemsItem?): LocationData? {
        return if (value == null) {
            null
        } else {

            LocationData(
                value.venue?.id?.toInt(),
                value.venue?.name,
                value.venue?.popularityByGeo,
                value.venue?.location?.country,
                value.venue?.location?.distance,
                value.venue?.location?.city,
                value.venue?.location?.postalCode,
                value.venue?.location?.state,
                value.venue?.location?.crossStreet,
                value.venue?.location?.address,
                value.venue?.categories?.get(0)?.pluralName,
                value.venue?.categories?.get(0)?.icon?.prefix + value.venue?.categories?.get(0)?.icon?.suffix,
                value.venue?.categories?.get(0)?.shortName
            )

        }
    }
}