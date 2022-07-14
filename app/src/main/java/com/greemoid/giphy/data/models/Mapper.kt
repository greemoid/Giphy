package com.greemoid.giphy.data.models

interface Mapper<in I, out O> {

    operator fun invoke(input: I): O
}