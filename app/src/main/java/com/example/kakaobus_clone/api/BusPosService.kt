package com.example.kakaobus_clone.api

import com.example.kakaobus_clone.data.BusPosByRouteStListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Used to connect to the 서울특별시_버스위치정보조회 서비스 API
 */
interface BusPosService {

    @GET("getBusPosByRouteSt")
    suspend fun getBusPosByRouteStList(
        @Query("ServiceKey") serviceKey: String,
        @Query("busRouteId") busRouteId: String,
        @Query("startOrd") startOrd: Int,
        @Query("endOrd") endOrd: Int,
    ): BusPosByRouteStListResponse

    companion object {
        private const val BASE_URL = "http://ws.bus.go.kr/api/rest/buspos/"

        fun create(): BusPosService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BusPosService::class.java)
        }
    }
}