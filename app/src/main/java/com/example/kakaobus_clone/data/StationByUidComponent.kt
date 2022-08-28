package com.example.kakaobus_clone.data

import com.google.gson.annotations.SerializedName

data class StationByUidComponent(
    @SerializedName("adirection") val direction: String,
    @SerializedName("stId") val stationId: String,
    @SerializedName("stNm") val stationName: String,
    @SerializedName("arsId") val arsId: String,
    @SerializedName("busRouteId") val busRouteId: String,
    @SerializedName("rtNm") val routeName: String,
    @SerializedName("routeType") val routeType: String,
    @SerializedName("arrmsg1") val firstArrMsg: String,
    @SerializedName("arrmsg12") val secondArrMsg: String,
    @SerializedName("isFullFlag1") val isFirstFull: String,
    @SerializedName("isFullFlag2") val isSecondFull: String,
)
