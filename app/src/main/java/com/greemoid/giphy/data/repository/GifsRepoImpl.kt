package com.greemoid.giphy.data.repository

import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.repository.GifsRepository

class GifsRepoImpl() : GifsRepository {
    override suspend fun fetchGifs(): List<Giphy> {
        return fetchGifs()
    }
}