package com.greemoid.giphy.data.api

import com.greemoid.giphy.data.models.GifModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsApi {

    @GET("trending?")
    suspend fun fetchTrendingGifs(
        @Query("api_key") apiKey: String = "yNrwmnFgUTwrgBnlOSCD8nU4c30RQGUn", //todo remove api from this query
        @Query("limit") limit: Int = 200,
        @Query("offset") offset: Int = 200,
        @Query("rating") rating: String = "g",
    ): GifModel

    @GET("search?")
    suspend fun fetchSearchGifs(
        @Query("api_key") apiKey: String = "yNrwmnFgUTwrgBnlOSCD8nU4c30RQGUn",
        @Query("q") searchQuery: String,
        @Query("limit") limit: Int = 200,
        @Query("rating") rating: String = "g",
        @Query("lang") lang: String = "en",
    ) : GifModel

}