package com.example.kakaobus_clone.data.response

import com.example.kakaobus_clone.api.RouteByStationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 싱글톤으로 객체를 생성
 */

object RouteByStationResponse {
    private const val BASE_URL = "http://ws.bus.go.kr/api/rest/stationinfo/"

    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRouteByStationService : RouteByStationService by lazy {
        retrofit.create(RouteByStationService::class.java)
    }
}