package com.example.kakaobus_clone.data.assets

import com.example.kakaobus_clone.data.models.MyListStation

fun myListStationSample(): List<MyListStation> {
    return listOf(
        MyListStation(
            stationId = 122000156,
            stationCode = 23259,
            stationName = "선릉역",
            direction = "포스코빌딩 방면"
        )
    )
}