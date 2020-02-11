package com.m.koltincoroutineandretrofit.home.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelCharacters(
    val id: Int = 0,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("status") val status: String = "",
    @SerializedName("copyright") val copyright: String = "",
    @SerializedName("attributionText") val attributionText: String = "",
    @SerializedName("attributionHTML") val attributionHTML: String = "",
    @SerializedName("etag") val etag: String = "",
    @SerializedName("data") val data: Data = Data(0, 0, 0, 0, mutableListOf())
) : Parcelable