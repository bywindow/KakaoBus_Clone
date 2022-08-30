package com.example.kakaobus_clone.viewmodels

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.*
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.assets.myListStationSample
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.data.repository.RouteByStationRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class BottomSheetAddBusViewModel(private val repository: RouteByStationRepository) : ViewModel() {
    private val _routeList = MutableLiveData<RouteByStation>()
    val routeList: LiveData<RouteByStation>
        get() = _routeList
    private val _typedRoute = MutableLiveData<Map<String, String>>()
    val typedRoute: LiveData<Map<String, String>>
        get() = _typedRoute
    private val _starredRoute = MutableLiveData<Map<String, Boolean>>()
    val starredRoute: LiveData<Map<String, Boolean>>
        get() = _starredRoute
    val busTypes = arrayListOf<String>("공용버스", "공항버스", "마을버스", "간선버스", "지선버스", "순환버스", "광역버스", "광역버스", "직행버스", "폐지버스")

    init {
        viewModelScope.launch {
            val arsId = myListStationSample().last().stationCode
            val temp: MutableMap<String, String> = mutableMapOf()
            val starredTemp : MutableMap<String, Boolean> = mutableMapOf()
            _routeList.value = repository.load(arsId)
            _routeList.value?.data?.routes?.forEach {
//                Log.d("arsId", it.toString())
                var name = it.busRouteNm
                name = name.replace("[\\u3131-\\u3163\\uac00-\\ud7a3]+".toRegex(), "")
                name = name.replace("()", " (퇴근)")
                if (name[0] == 'N') name = "$name (심야)"
//                Log.d("arsId", name)
                temp.put(it.busRouteType, "${temp[it.busRouteType]}\n$name")
                starredTemp.put(name, false)
            }
            _typedRoute.value = temp
            _starredRoute.value = starredTemp
//            Log.d("arsId", _typedRoute.value?.entries.toString())
        }
    }

    // Factory Pattern
    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BottomSheetAddBusViewModel(RouteByStationRepository.getInstance(application)!!) as T
        }
    }

}