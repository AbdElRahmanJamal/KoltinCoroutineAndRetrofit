package com.m.koltincoroutineandretrofit.home

import com.m.koltincoroutineandretrofit.APIsStatus
import com.m.koltincoroutineandretrofit.home.entities.MarvelCharacters
import com.m.koltincoroutineandretrofit.network.APIS
import com.marvelapp.coroutines.AppExceptions
import retrofit2.Response

class HomePageDataStore(private val apis: APIS) {

    suspend fun getMarvelCharacters(limit: Int, offset: Int): APIsStatus<MarvelCharacters> {
        var states: APIsStatus<MarvelCharacters>? = null

        runCatching {
            apis.getMarvelCharactersAsync(limit, offset)
        }.onSuccess {
            states = if (it.isSuccessful) {
                getDataOrThrowException(it)
            } else {
                throwException(it)
            }

        }.onFailure {
            states = APIsStatus.ErrorState(it)
        }

        return states!!
    }

    private fun throwException(it: Response<MarvelCharacters>): APIsStatus<MarvelCharacters>? {
        return it.errorBody()?.let { responseBody ->
            if (responseBody.toString().isEmpty()) {
                APIsStatus.ErrorState(AppExceptions.EmptyBodyException)
            } else {
                APIsStatus.ErrorState(AppExceptions.GenericErrorException(responseBody.string()))
            }
        }
            ?: APIsStatus.ErrorState(AppExceptions.GenericErrorException("Some thing did't go as planned"))
    }

    private fun getDataOrThrowException(
        it: Response<MarvelCharacters>
    ): APIsStatus<MarvelCharacters>? {
        return it.body()?.let {
            if (it.toString().isEmpty()) {
                APIsStatus.ErrorState(AppExceptions.EmptyBodyException)
            } else {
                APIsStatus.DataStat(it)
            }
        } ?: APIsStatus.ErrorState(AppExceptions.EmptyBodyException)
    }
}
