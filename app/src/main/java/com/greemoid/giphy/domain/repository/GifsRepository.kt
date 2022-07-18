package com.greemoid.giphy.domain.repository

import com.greemoid.giphy.domain.models.Giphy

interface GifsRepository {

    suspend fun fetchTrendingGifs(): List<Giphy>

    suspend fun fetchSearchGifs(searchQuery: String): List<Giphy>

}