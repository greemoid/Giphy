package com.greemoid.giphy.data.repository

import com.greemoid.giphy.data.GifsMapper
import com.greemoid.giphy.data.api.GifsApi
import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GifsSource(
    private val gifsApi: GifsApi,
    private val mapper: GifsMapper
): GifsRepository {

    override suspend fun fetchTrendingGifs(): List<Giphy> =
        withContext(Dispatchers.IO) {
            val trendingGifs = gifsApi.fetchTrendingGifs()
            mapper.invoke(trendingGifs)
        }

    override suspend fun fetchSearchGifs(searchQuery: String): List<Giphy> =
        withContext(Dispatchers.IO) {
            val searchGifs = gifsApi.fetchSearchGifs(searchQuery = searchQuery)
            mapper.invoke(searchGifs)
        }
    }
