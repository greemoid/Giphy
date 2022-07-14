package com.greemoid.giphy.data.repository

import android.util.Log
import com.greemoid.giphy.data.api.GifsApi
import com.greemoid.giphy.domain.models.DataResult
import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class TrendingGifsSource(
    private val gifsApi: GifsApi,
    private val mapper: GifsMapper
): GifsRepository {
    override suspend fun fetchGifs(): List<Giphy> =
        withContext(Dispatchers.IO) {
            val trendingGifs = gifsApi.fetchTrendingGifs()
            mapper.invoke(trendingGifs)
        }


}