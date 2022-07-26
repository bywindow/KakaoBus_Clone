package com.example.kakaobus_clone.data

import com.google.gson.annotations.SerializedName

data class getArrInfoByRouteAllResponse(
    @field:SerializedName("msgBody") val msgBody: dataBody
)

data class dataBody(
    @field:SerializedName("itemList") val itemList: List<RouteAllList>,
)