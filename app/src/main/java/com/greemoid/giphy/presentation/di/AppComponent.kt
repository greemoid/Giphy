package com.greemoid.giphy.presentation.di

import com.greemoid.giphy.data.di.dataRemoteModule
import com.greemoid.giphy.domain.di.domainUseCaseModule

val appComponent = listOf(
    presentationModule,
    domainUseCaseModule,
    dataRemoteModule
)