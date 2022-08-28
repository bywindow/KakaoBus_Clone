package com.example.kakaobus_clone.api

import com.example.kakaobus_clone.BuildConfig
import com.example.kakaobus_clone.data.models.RouteByStation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RouteByStationService {
    @GET("getStationByUid")
    suspend fun getRoute(
        @Query("serviceKey", encoded=true) serviceKey: String = BuildConfig.API_SERVICE_KEY,
        @Query("arsId") arsId: Int,
        @Query("resultType") resultType: String = "json"
    ): Response<RouteByStation>
}