package com.m.koltincoroutineandretrofit

sealed class APIsStatus<out T : Any> {
    class DataStat<T : Any>(val value: T) : APIsStatus<T>()
    class ErrorState(val exception: Throwable) : APIsStatus<Nothing>()
    object LoadingState : APIsStatus<Nothing>()

}