package com.m.koltincoroutineandretrofit.home.presenration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.m.koltincoroutineandretrofit.home.HomePageRepository

class HomePageViewModelFactory(
    private val homePageRepository: HomePageRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomePageViewModel(homePageRepository) as T
    }
}