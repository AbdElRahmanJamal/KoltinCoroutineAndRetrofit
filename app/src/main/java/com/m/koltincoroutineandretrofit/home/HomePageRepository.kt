package com.m.koltincoroutineandretrofit.home

class HomePageRepository(
    private val homePageDataStore: HomePageDataStore
) {
    suspend fun getMarvelCharacters(limit: Int, offset: Int) =
        homePageDataStore.getMarvelCharacters(limit, offset)
}

