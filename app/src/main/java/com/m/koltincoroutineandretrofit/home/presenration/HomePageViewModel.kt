package com.m.koltincoroutineandretrofit.home.presenration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.m.koltincoroutineandretrofit.APIsStatus
import com.m.koltincoroutineandretrofit.home.HomePageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel(private val homePageRepository: HomePageRepository) : ViewModel() {

    fun getMarvelCharactersAsync(limit: Int, offset: Int) =
        liveData(Dispatchers.IO) {

            emit(APIsStatus.LoadingState)
            val marvelCharacters = homePageRepository.getMarvelCharacters(limit, offset)
            emit((marvelCharacters))

        }
}
