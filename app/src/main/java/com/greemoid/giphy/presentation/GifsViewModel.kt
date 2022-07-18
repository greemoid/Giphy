package com.greemoid.giphy.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.giphy.domain.models.Giphy
import com.greemoid.giphy.domain.usecases.GetSearchGifsUseCase
import com.greemoid.giphy.domain.usecases.GetTrendingGifsUseCase
import kotlinx.coroutines.launch

class GifsViewModel(
    val trendingGifsUseCase: GetTrendingGifsUseCase,
    val searchGifsUseCase: GetSearchGifsUseCase,
) : ViewModel() {

    private val _trendingGifs: MutableLiveData<List<Giphy>> = MutableLiveData()
    val trendingGifs: LiveData<List<Giphy>> = _trendingGifs

    private val _searchGifs: MutableLiveData<List<Giphy>> = MutableLiveData()
    val searchGifs: LiveData<List<Giphy>> = _searchGifs

    fun getTrendingGifs() = viewModelScope.launch {
        _trendingGifs.postValue(trendingGifsUseCase.fetchTrendingGifs())
    }

    fun getSearchGifs(searchQuery: String) = viewModelScope.launch {
        _searchGifs.postValue(searchGifsUseCase.fetchSearchGifs(searchQuery = searchQuery))
    }

}