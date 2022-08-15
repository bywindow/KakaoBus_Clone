package com.example.kakaobus_clone.data.repository

/**
 * 1. retrofit으로 통신하여 결과를 가져온다
 *  - 성공 시 body를 data class에 맞게 리턴
 *  - 실패 시 아무것도 없는 형태의 데이터 리턴
 * 2. 싱글톤 패턴 : 같은 시간에 여러 인스턴스가 하나의 Repository에 접근하는 것을 막는다
 */

import android.app.Application
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.data.models.RouteByStationList
import com.example.kakaobus_clone.data.response.RouteByStationResponse

class RouteByStationRepository(application: Application) {
    suspend fun load(arsId: Int) : RouteByStation {
        val response = RouteByStationResponse.getRouteByStationService.getRoute(arsId = arsId)
        return if(response.isSuccessful) response.body() as RouteByStation else RouteByStation(RouteByStationList(ArrayList()))
    }

    companion object {
        private var instance: RouteByStationRepository? = null

        fun getInstance(application: Application): RouteByStationRepository? {
            if (instance == null) instance = RouteByStationRepository(application)
            return instance
        }
    }
}