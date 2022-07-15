package com.greemoid.giphy.domain.di

import com.greemoid.giphy.domain.usecases.GetSearchGifsUseCase
import com.greemoid.giphy.domain.usecases.GetTrendingGifsUseCase
import org.koin.dsl.module

val domainUseCaseModule = module {

    single {
        GetTrendingGifsUseCase(
            repository = get()
        )
    }

    single {
        GetSearchGifsUseCase(
            repository = get()
        )
    }
}