package com.greemoid.giphy.domain.usecases

import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository
import retrofit2.http.Query

class GetSearchGifsUseCase(private val repository: GifsRepository) {

    suspend fun fetchSearchGifs(limit: Int = 25, searchQuery: String): List<Giphy> =
        repository.fetchSearchGifs(limit, searchQuery)
}