package com.example.kakaobus_clone.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.kakaobus_clone.data.assets.myListStationSample
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.data.repository.RouteByStationRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class BottomSheetAddBusViewModel(private val repository: RouteByStationRepository) : ViewModel() {
    private val _routeList = MutableLiveData<RouteByStation>()
    val routeList: LiveData<RouteByStation>
        get() = _routeList
    private var _typedRoute = MutableLiveData<Map<String, String>>()
    val typedRoute: LiveData<Map<String, String>>
        get() = _typedRoute

    init {
        viewModelScope.launch {
            val arsId = myListStationSample().last().stationCode
            val temp: MutableMap<String, String> = mutableMapOf()
            _routeList.value = repository.load(arsId)
            _routeList.value?.data?.routes?.forEach {
//                Log.d("arsId", it.toString())
                var name = it.busRouteNm
                name = name.replace("[\\u3131-\\u3163\\uac00-\\ud7a3]+".toRegex(), "")
                name = name.replace("()", " (퇴근)")
                if (name[0] == 'N') name = "$name (심야)"
//                Log.d("arsId", name)
                temp.put(
                    it.busRouteType, "${temp[it.busRouteType]}\n$name")
            }
            _typedRoute.value = temp
            Log.d("arsId", _typedRoute.value?.entries.toString())
        }
    }

    // Factory Pattern
    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BottomSheetAddBusViewModel(RouteByStationRepository.getInstance(application)!!) as T
        }
    }
}