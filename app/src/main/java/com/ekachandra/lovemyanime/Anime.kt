package com.ekachandra.lovemyanime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val title: String,
    val photo: Int,
    val score: String,
    val genres: String,
    val synopsis: String
) : Parcelable
