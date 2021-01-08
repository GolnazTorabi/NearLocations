package com.cafebazaar.test.nearlocations.location.domain.model

import androidx.room.*
import com.cafebazaar.test.nearlocations.location.data.response.Location
import com.cafebazaar.test.nearlocations.utils.database.converter.StringConverter
import com.fasterxml.jackson.annotation.JsonProperty

@Entity(tableName = "Locations")
@TypeConverters(StringConverter::class)
data class LocationData(
    @PrimaryKey(autoGenerate = true)
    val locationId: Int? = null,
    val name: String? = null,
    val popularityByGeo: Double? = null,
    val country: String? = null,
    val distance: Int? = null,
    val city: String? = null,
    val postalCode: String? = null,
    val state: String? = null,
    val crossStreet: String? = null,
    val address: String? = null,
    val pluralName: String? = null,
    val Icon: String? = null,
    val shortName: String? = null
)