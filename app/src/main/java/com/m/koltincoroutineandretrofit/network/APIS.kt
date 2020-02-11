package com.m.koltincoroutineandretrofit.network

import com.m.koltincoroutineandretrofit.APIsStatus
import com.m.koltincoroutineandretrofit.home.entities.MarvelCharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIS {

    @GET("v1/public/characters")
    suspend fun getMarvelCharactersAsync(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<MarvelCharacters>
}