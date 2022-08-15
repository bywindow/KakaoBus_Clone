package com.example.kakaobus_clone.data

/**
 * URL : http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid
 * arsId - 정류소고유번호 : 이것을 사용해야 함
 */
import com.google.gson.annotations.SerializedName

data class RouteByStationComponent(
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
