package com.greemoid.giphy.domain.models

import java.io.Serializable

data class Giphy(
    val height: String,
    val size: String,
    val url: String,
    val width: String
) : Serializable
