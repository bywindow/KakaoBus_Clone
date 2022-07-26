package com.example.kakaobus_clone.data

import com.google.gson.annotations.SerializedName

data class RouteAllList(
    @field:SerializedName("stId") val stId: String,
    @field:SerializedName("stNm") val stNm: String,
    @field:SerializedName("busRouteId") val busRouteId: String,
    @field:SerializedName("rtNm") val rtNm: String,
    @field:SerializedName("arsId") val arsId: String,
    @field:SerializedName("routeType") val routeType: String,
)
