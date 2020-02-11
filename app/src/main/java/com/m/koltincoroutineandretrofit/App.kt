package com.m.koltincoroutineandretrofit

import android.app.Application
import com.m.koltincoroutineandretrofit.network.apiFactory
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Domain.integrateWith(this)
        startKoin(applicationContext, listOf(apiFactory))
    }
}
