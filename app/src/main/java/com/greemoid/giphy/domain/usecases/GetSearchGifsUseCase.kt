package com.greemoid.giphy.domain.usecases

import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository

class GetSearchGifsUseCase(private val repository: GifsRepository) {

    suspend fun fetchSearchGifs( searchQuery: String): List<Giphy> =
        repository.fetchSearchGifs(searchQuery)
}