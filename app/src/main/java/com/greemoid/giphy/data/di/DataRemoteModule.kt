package com.greemoid.giphy.data.di

import com.greemoid.giphy.data.api.GifsApi
import com.greemoid.giphy.data.repository.GifsMapper
import com.greemoid.giphy.data.repository.TrendingGifsSource
import com.greemoid.giphy.domain.repository.GifsRepository
import com.greemoid.giphy.presentation.utils.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataRemoteModule = module {
    single {
        createRetrofit()
    }

    single { get<Retrofit>().create(GifsApi::class.java) }

    single { GifsMapper() }

    single<GifsRepository> { TrendingGifsSource(
        gifsApi = get(),
        mapper = get()
    ) }


}



fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


