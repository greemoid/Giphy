package com.greemoid.giphy.presentation.di

import com.greemoid.giphy.data.api.GifsApi
import com.greemoid.giphy.data.GifsMapper
import com.greemoid.giphy.data.repository.GifsSource
import com.greemoid.giphy.domain.repository.GifsRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataRemoteModule = module {
    single {
        createRetrofit()
    }

    single { get<Retrofit>().create(GifsApi::class.java) }

    single { GifsMapper() }

    single<GifsRepository> {
        GifsSource(
            gifsApi = get(),
            mapper = get()
        )
    }
}

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

const val BASE_URL = "https://api.giphy.com/v1/gifs/"


