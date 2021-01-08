package com.cafebazaar.test.nearlocations.location.data.response

import com.fasterxml.jackson.annotation.JsonProperty
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseLocationsList(

	@field:JsonProperty("meta")
	val meta: Meta? = null,

	@field:JsonProperty("response")
	val response: Response? = null
) : Parcelable

@Parcelize
data class Venue(

	@field:JsonProperty("popularityByGeo")
	val popularityByGeo: Double? = null,

	@field:JsonProperty("venuePage")
	val venuePage: VenuePage? = null,

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("location")
	val location: Location? = null,

	@field:JsonProperty("id")
	val id: String? = null,

	@field:JsonProperty("categories")
	val categories: List<CategoriesItem?>? = null
) : Parcelable

@Parcelize
data class Location(

	@field:JsonProperty("cc")
	val cc: String? = null,

	@field:JsonProperty("country")
	val country: String? = null,

	@field:JsonProperty("address")
	val address: String? = null,

	@field:JsonProperty("labeledLatLngs")
	val labeledLatLngs: List<LabeledLatLngsItem?>? = null,

	@field:JsonProperty("lng")
	val lng: Double? = null,

	@field:JsonProperty("distance")
	val distance: Int? = null,

	@field:JsonProperty("formattedAddress")
	val formattedAddress: List<String?>? = null,

	@field:JsonProperty("city")
	val city: String? = null,

	@field:JsonProperty("postalCode")
	val postalCode: String? = null,

	@field:JsonProperty("state")
	val state: String? = null,

	@field:JsonProperty("crossStreet")
	val crossStreet: String? = null,

	@field:JsonProperty("lat")
	val lat: Double? = null
) : Parcelable

@Parcelize
data class Reasons(

	@field:JsonProperty("count")
	val count: Int? = null,

	@field:JsonProperty("items")
	val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class Response(

	@field:JsonProperty("totalResults")
	val totalResults: Int? = null,

	@field:JsonProperty("suggestedRadius")
	val suggestedRadius: Int? = null,

	@field:JsonProperty("headerFullLocation")
	val headerFullLocation: String? = null,

	@field:JsonProperty("warning")
	val warning: Warning? = null,

	@field:JsonProperty("headerLocationGranularity")
	val headerLocationGranularity: String? = null,

	@field:JsonProperty("groups")
	val groups: List<GroupsItem?>? = null,

	@field:JsonProperty("suggestedBounds")
	val suggestedBounds: SuggestedBounds? = null,

	@field:JsonProperty("headerLocation")
	val headerLocation: String? = null
) : Parcelable

@Parcelize
data class Sw(

	@field:JsonProperty("lng")
	val lng: Double? = null,

	@field:JsonProperty("lat")
	val lat: Double? = null
) : Parcelable

@Parcelize
data class Warning(

	@field:JsonProperty("text")
	val text: String? = null
) : Parcelable

@Parcelize
data class Ne(

	@field:JsonProperty("lng")
	val lng: Double? = null,

	@field:JsonProperty("lat")
	val lat: Double? = null
) : Parcelable

@Parcelize
data class CategoriesItem(

	@field:JsonProperty("pluralName")
	val pluralName: String? = null,

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("icon")
	val icon: Icon? = null,

	@field:JsonProperty("id")
	val id: String? = null,

	@field:JsonProperty("shortName")
	val shortName: String? = null,

	@field:JsonProperty("primary")
	val primary: Boolean? = null
) : Parcelable

@Parcelize
data class GroupsItem(

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("type")
	val type: String? = null,

	@field:JsonProperty("items")
	val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class LabeledLatLngsItem(

	@field:JsonProperty("lng")
	val lng: Double? = null,

	@field:JsonProperty("label")
	val label: String? = null,

	@field:JsonProperty("lat")
	val lat: Double? = null
) : Parcelable

@Parcelize
data class SuggestedBounds(

	@field:JsonProperty("sw")
	val sw: Sw? = null,

	@field:JsonProperty("ne")
	val ne: Ne? = null
) : Parcelable

@Parcelize
data class Meta(

	@field:JsonProperty("code")
	val code: Int? = null,

	@field:JsonProperty("requestId")
	val requestId: String? = null
) : Parcelable

@Parcelize
data class VenuePage(

	@field:JsonProperty("id")
	val id: String? = null
) : Parcelable

@Parcelize
data class ItemsItem(

	@field:JsonProperty("venue")
	val venue: Venue? = null,

	@field:JsonProperty("reasons")
	val reasons: Reasons? = null,

	@field:JsonProperty("summary")
	val summary: String? = null,

	@field:JsonProperty("reasonName")
	val reasonName: String? = null,

	@field:JsonProperty("type")
	val type: String? = null
) : Parcelable

@Parcelize
data class Icon(

	@field:JsonProperty("prefix")
	val prefix: String? = null,

	@field:JsonProperty("suffix")
	val suffix: String? = null
) : Parcelable
