package com.example.kakaobus_clone.data.models

/**
 * api response에서 <msgBody> 안에 <itemList> 배열로 정보가 존재하므로
 * data class 태크 매핑이 두개 필요
 */

import com.example.kakaobus_clone.data.RouteByStationComponent
import com.google.gson.annotations.SerializedName

data class RouteByStation(
    @SerializedName("msgBody") val data: RouteByStationList
)

data class RouteByStationList(
    @SerializedName("itemList") val routes: List<RouteByStationComponent>
)
