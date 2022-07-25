package com.example.kakaobus_clone.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaobus_clone.HomeViewPagerFragment
import com.example.kakaobus_clone.HomeViewPagerFragmentDirections
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.models.MyListStation
import com.example.kakaobus_clone.databinding.MyListItemBinding
import com.example.kakaobus_clone.viewmodels.MyListStationViewModel

class MyListStationAdapter(private var stationList: List<MyListStation>):
    RecyclerView.Adapter<MyListStationAdapter.ViewHolder>(){

    class ViewHolder(
        private val binding: MyListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        val stationName: TextView = itemView.findViewById(R.id.station_text)
        val direction: TextView = itemView.findViewById(R.id.direction_text)
        init {
            binding.setClickListener {
                binding.viewmodel?.station?.let { station ->
                    navigateToDetail(station, it)
                    Log.d("station", station.toString())
                }
            }
        }
        private fun navigateToDetail(station: MyListStation, view: View){
            val direction = HomeViewPagerFragmentDirections
                .actionViewPagerFragmentToTimelinesFragment(station)
            view.findNavController().navigate(direction)
        }
        fun bind(station: MyListStation) {
            with(binding) {
                viewmodel = MyListStationViewModel(station)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.my_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.stationName.text = stationList[position].stationName
//        holder.direction.text = stationList[position].direction
        holder.bind(stationList[position])
    }

    override fun getItemCount(): Int {
        return stationList.size
    }

}