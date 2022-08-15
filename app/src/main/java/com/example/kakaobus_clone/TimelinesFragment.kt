package com.example.kakaobus_clone

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.kakaobus_clone.api.RouteAllListService
import com.example.kakaobus_clone.data.getArrInfoByRouteAllResponse
import com.example.kakaobus_clone.databinding.FragmentTiemlinesBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TimelinesFragment : Fragment() {

    private val BASE_URL = "http://ws.bus.go.kr/api/rest/arrive/"
    private val args: TimelinesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTiemlinesBinding.inflate(inflater, container, false)
//        Log.d("timeline", args.toString())
        fetchData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stationNumber: TextView = view.findViewById(R.id.station_number_text)
        val stationName: TextView = view.findViewById(R.id.station_name_text)
        val stationDirection: TextView = view.findViewById(R.id.station_direction_text)

        stationNumber.text = args.station.stationCode.toString()
        stationName.text = args.station.stationName
        stationDirection.text = args.station.direction
    }

    private fun fetchData(){
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RouteAllListService::class.java)

        val response = retrofit.getArrInfoByRouteAll(busRouteId = "100100025")

        response.enqueue(object : Callback<getArrInfoByRouteAllResponse> {
            override fun onResponse(
                call: Call<getArrInfoByRouteAllResponse>,
                response: Response<getArrInfoByRouteAllResponse>
            ) {
                Log.d("fetch", "success : ${response.body()?.msgBody?.itemList?.size}")
            }

            override fun onFailure(call: Call<getArrInfoByRouteAllResponse>, t: Throwable) {
                Log.d("fetch", "fail : $t")
            }
        })
    }

}