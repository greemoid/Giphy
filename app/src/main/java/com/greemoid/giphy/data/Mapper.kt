package com.greemoid.giphy.data

interface Mapper<in I, out O> {

    operator fun invoke(input: I): O
}