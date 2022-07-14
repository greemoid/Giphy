package com.greemoid.giphy.domain.repository

import com.greemoid.giphy.domain.models.Giphy

interface GifsRepository {

    suspend fun fetchGifs(): List<Giphy>

}