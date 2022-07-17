package com.greemoid.giphy.domain.repository

import com.greemoid.giphy.domain.models.Giphy

interface GifsRepository {

    suspend fun fetchTrendingGifs(limit: Int = 200): List<Giphy>

    suspend fun fetchSearchGifs(limit: Int = 200, searchQuery: String): List<Giphy>

}