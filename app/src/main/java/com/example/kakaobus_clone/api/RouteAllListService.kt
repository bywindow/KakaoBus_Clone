package com.example.kakaobus_clone.api

import com.example.kakaobus_clone.BuildConfig
import com.example.kakaobus_clone.data.getArrInfoByRouteAllResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RouteAllListService {

    @GET("getArrInfoByRouteAll")
    fun getArrInfoByRouteAll(
        @Query("serviceKey", encoded=true) serviceKey: String = BuildConfig.API_SERVICE_KEY,
        @Query("busRouteId") busRouteId: String,
        @Query("resultType") resultType: String = "json"
    ): Call<getArrInfoByRouteAllResponse>

//    companion object {
//        private const val BASE_URL = "http://ws.bus.go.kr/api/rest/arrive/"
//        fun create(): RouteAllListService {
//            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(logger)
//                .build()
//
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(RouteAllListService::class.java)
//        }
//    }
}