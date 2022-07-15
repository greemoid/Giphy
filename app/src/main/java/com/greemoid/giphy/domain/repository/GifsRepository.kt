package com.greemoid.giphy.domain.repository

import com.greemoid.giphy.domain.models.Giphy

interface GifsRepository {

    suspend fun fetchTrendingGifs(limit: Int = 25): List<Giphy>

    suspend fun fetchSearchGifs(limit: Int = 25, searchQuery: String): List<Giphy>

}