package com.greemoid.giphy.presentation.di

import com.greemoid.giphy.presentation.fragments.GifsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        GifsViewModel(trendingGifsUseCase = get(), searchGifsUseCase = get())
    }
}