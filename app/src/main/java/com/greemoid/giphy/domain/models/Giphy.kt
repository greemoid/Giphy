package com.greemoid.giphy.domain.models

import java.io.Serializable

data class Giphy(
    val height: String,
    val size: String,
    val url_large: String,
    val url_medium: String,
    val width: String
) : Serializable
