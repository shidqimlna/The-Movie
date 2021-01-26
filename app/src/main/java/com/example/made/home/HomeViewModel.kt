package com.example.made.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.made.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val movie = movieUseCase.getAllMovie().asLiveData()

    @ExperimentalCoroutinesApi
    private val queryChannel = ConflatedBroadcastChannel<String>()

    @ExperimentalCoroutinesApi
    fun setSearchQuery(search: String) {
        queryChannel.offer(search)
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    val search = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .flatMapLatest {
            movieUseCase.getSearchMovie(it)
        }.asLiveData()

}