package com.greemoid.giphy.data

import com.greemoid.giphy.data.models.GifModel
import com.greemoid.giphy.domain.models.Giphy

class GifsMapper : Mapper<GifModel, List<Giphy>> {
    override fun invoke(input: GifModel): List<Giphy> {
        val giphyList = mutableListOf<Giphy>()
        input.data.forEach {
            giphyList.add(Giphy(
                url_large = it.images.downsized_large.url,
            ))
        }
        return giphyList
    }

}