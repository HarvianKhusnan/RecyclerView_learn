package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val desciption: String,
    val photo: Int
) : Parcelable
