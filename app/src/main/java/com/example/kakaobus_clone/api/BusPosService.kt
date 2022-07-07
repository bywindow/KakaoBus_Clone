package com.example.kakaobus_clone.api

import retrofit2.http.GET


/**
 * Used to connect to the 서울특별시_버스위치정보조회 서비스 API
 */
interface BusPosService {

    //노선별 특정 정류소 접근 버스 위치정보 목록 조회
    @GET()
    suspend fun getBusPosByRouteStList(){

    }

    companion object {
        private const val BASE_URL = "http://ws.bus.go.kr/api/rest/buspos/"
    }
}