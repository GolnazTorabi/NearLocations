package com.cafebazaar.test.nearlocations.location.data.api

import com.cafebazaar.test.nearlocations.location.data.response.ResponseLocationsList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {
    @GET("/v2/venues/explore")
    fun getNearLocations(@Query("ll") latLang: String, @Query("offset") page: Int): Single<ResponseLocationsList>
}