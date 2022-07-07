package com.example.kakaobus_clone.data

import com.google.gson.annotations.SerializedName

data class BusPosByRouteStList(
    @field:SerializedName("sectOrd") val sectOrd: Int, //구간순번
    @field:SerializedName("sectDist") val sectDist: Int, //구간옵셋거리(km)
    @field:SerializedName("stopFlag") val stopFlag: Int, //정류소도착여부 (0:운행중, 1:도착)
    @field:SerializedName("sectionId") val sectionId: String, //구간 ID
    @field:SerializedName("dataTm") val dataTm: String, //제공시간
    @field:SerializedName("tmx") val tmx: String, // 맵매칭 x 좌표 (WGS84)
    @field:SerializedName("tmy") val tmy: String, // 맵매칭 y 좌표 (WGS84)
    @field:SerializedName("vehId") val vehId: String, //버스 ID
    @field:SerializedName("plainNo") val plainNo: String, //차량번호
    @field:SerializedName("busType") val busType: Int, //차량유형 (0:일반, 1:저상, 2:굴절)
    @field:SerializedName("lastStnId") val lastStnId: String, //최종정류장ID
    @field:SerializedName("posX") val posX: String, //맵매칭 x 좌표 (GRS80)
    @field:SerializedName("posY") val posY: String, //맵매칭 y 좌표 (GRS80)
    @field:SerializedName("routeId") val routeId: String, //노선ID
)
