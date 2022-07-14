package com.greemoid.giphy.data.api

import com.greemoid.giphy.data.models.GifModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsApi {

    @GET("trending?")
    suspend fun fetchTrendingGifs(
        @Query("api_key") apiKey: String = "yNrwmnFgUTwrgBnlOSCD8nU4c30RQGUn", //todo remove api from this query
        @Query("limit") limit: Int = 25,
        @Query("rating") rating: String = "g",
    ): GifModel
}