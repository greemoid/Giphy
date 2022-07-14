package com.greemoid.giphy.data.repository

import com.greemoid.giphy.domain.models.Giphy

interface GifsStorage {

    fun fetch(): List<Giphy>
}