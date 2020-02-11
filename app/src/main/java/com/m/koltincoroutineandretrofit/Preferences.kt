package com.m.koltincoroutineandretrofit

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.m.koltincoroutineandretrofit.home.entities.MarvelCharacters


private const val NAME = "PREFERENCES_NAME"
val preferencesGateway by lazy {
    Preferences(Domain.application.getSharedPreferences(NAME, Context.MODE_PRIVATE))
}

object Domain {

    internal lateinit var application: Application private set
    fun integrateWith(application: Application) {
        this.application = application
    }

}


class Preferences(val sharedPreferences: SharedPreferences) {


    suspend fun <T : Any> save(key: String, value: T) {
        sharedPreferences.edit().apply { putValue(key, value) }.apply()
    }


     inline fun <reified T : Any> load(key: String, defaultValue: T): T {
        return sharedPreferences.getValue(key, defaultValue)
    }


    suspend fun isSaved(key: String): Boolean {
        return sharedPreferences.contains(key)
    }


    suspend fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }


}


fun <T : Any> SharedPreferences.Editor.putValue(key: String, value: T) {
    when (value::class) {
        Boolean::class -> putBoolean(key, value as Boolean)
        Int::class -> putInt(key, value as Int)
        Long::class -> putLong(key, value as Long)
        Float::class -> putFloat(key, value as Float)
        String::class -> putString(key, value as String)
        MarvelCharacters::class -> {
            val gson = Gson()
            val json = gson.toJson(value)
            putString(key, json)
        }
        else -> throw UnsupportedOperationException("not supported preferences type")
    }
}


fun <T : Any> SharedPreferences.getValue(key: String, defaultValue: T): T {
    return when (defaultValue::class) {
        Boolean::class -> getBoolean(key, defaultValue as Boolean) as T
        Int::class -> getInt(key, defaultValue as Int) as T
        Long::class -> getLong(key, defaultValue as Long) as T
        Float::class -> getFloat(key, defaultValue as Float) as T
        String::class -> getString(key, defaultValue as String) as T
        else -> throw UnsupportedOperationException("not supported preferences type")
    }
}
