package com.greemoid.giphy.data.repository

import com.greemoid.giphy.data.models.GifModel
import com.greemoid.giphy.data.models.Mapper
import com.greemoid.giphy.domain.models.Giphy

class GifsMapper : Mapper<GifModel, List<Giphy>> {
    override fun invoke(input: GifModel): List<Giphy> {
        val giphyList = mutableListOf<Giphy>()
        input.data.forEach {
            giphyList.add(Giphy(
                height = it.images.downsized_large.height,
                size = it.images.downsized_large.size,
                url = it.images.downsized_large.url,
                width = it.images.downsized_large.width))
        }
        return giphyList
    }

}