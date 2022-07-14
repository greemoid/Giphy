package com.greemoid.giphy.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.usecases.GetTrendingGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class GifsViewModel(val useCase: GetTrendingGifsUseCase): ViewModel() {

    private val _trendingGifs: MutableLiveData<List<Giphy>> = MutableLiveData()
    val trendingGifs: LiveData<List<Giphy>> = _trendingGifs

    fun getTrendingGifs() = viewModelScope.launch {
        _trendingGifs.postValue(useCase.fetchTrendingGifs())
    }
}