package com.example.marvelcomics.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Price(
    val price: Double,
    val type: String
) : Parcelable