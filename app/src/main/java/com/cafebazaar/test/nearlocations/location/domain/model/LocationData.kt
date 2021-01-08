package com.cafebazaar.test.nearlocations.location.domain.model

import androidx.room.*
import com.cafebazaar.test.nearlocations.location.data.response.Location
import com.cafebazaar.test.nearlocations.utils.database.converter.StringConverter

@Entity(tableName = "Locations")
@TypeConverters(StringConverter::class)
data class LocationData(
    @PrimaryKey(autoGenerate = true)
    val locationId: String? = null,
    val name: String? = null,
    val popularityByGeo: Double? = null,
    @SuppressWarnings(RoomWarnings.DEFAULT_CONSTRUCTOR)
    @Embedded(prefix = "loc")
    var location: Location? = null,
    val pluralName: String? = null,
    val Icon: String? = null,
    val shortName: String? = null
)