package com.example.kakaobus_clone.data

/**
 * URL : http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid
 * arsId - 정류소고유번호 : 이것을 사용해야 함
 */
import com.google.gson.annotations.SerializedName

data class RouteByStationComponent(
    @SerializedName("busRouteNm") val busRouteNm: String,
    @SerializedName("busRouteType") val busRouteType: String,
)
