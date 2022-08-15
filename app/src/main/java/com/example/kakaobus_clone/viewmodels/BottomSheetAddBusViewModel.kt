package com.example.kakaobus_clone.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kakaobus_clone.data.assets.myListStationSample
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.data.repository.RouteByStationRepository
import kotlinx.coroutines.launch

class BottomSheetAddBusViewModel(private val repository: RouteByStationRepository) : ViewModel() {
    private val _routeList = MutableLiveData<RouteByStation>()
    val routeList: MutableLiveData<RouteByStation>
        get() = _routeList
    val isStarred = false

    init {
        viewModelScope.launch {
            val arsId = myListStationSample().last().stationCode
            _routeList.value = repository.load(arsId)
        }
    }

    // Factory Pattern
    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BottomSheetAddBusViewModel(RouteByStationRepository.getInstance(application)!!) as T
        }
    }
}