package com.greemoid.giphy.domain.usecases

import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository

class GetTrendingGifsUseCase(private val repository: GifsRepository) {

    suspend fun fetchTrendingGifs(): List<Giphy> =
        repository.fetchTrendingGifs()
}