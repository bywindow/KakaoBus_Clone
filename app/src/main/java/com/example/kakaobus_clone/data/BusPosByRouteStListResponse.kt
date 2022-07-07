package com.example.kakaobus_clone.data

import com.google.gson.annotations.SerializedName

data class BusPosByRouteStListResponse(
    @field:SerializedName("itemList") val itemList: List<BusPosByRouteStList>,
    @field:SerializedName("itemCount") val itemCount: Int
)