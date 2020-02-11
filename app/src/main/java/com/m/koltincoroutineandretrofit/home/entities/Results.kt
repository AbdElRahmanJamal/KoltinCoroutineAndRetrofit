package com.m.koltincoroutineandretrofit.home.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.marvelapp.coroutines.marvelhome.data.entities.Urls
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Results(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("thumbnail") val thumbnail: Thumbnail?,
    @SerializedName("comics") val comics: Comics?,
    @SerializedName("series") val series: Series?,
    @SerializedName("stories") val stories: Stories?,
    @SerializedName("events") val events: Events?,
    @SerializedName("urls") val urls: List<Urls>?
) : Parcelable