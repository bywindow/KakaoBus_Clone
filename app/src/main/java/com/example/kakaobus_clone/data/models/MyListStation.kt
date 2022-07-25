package com.example.kakaobus_clone.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyListStation(
    val stationId: Long,
    val stationCode: Int,
    val stationName: String,
    val direction: String,
) : Parcelable
