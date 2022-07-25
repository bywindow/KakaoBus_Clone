package com.example.kakaobus_clone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.models.MyListStation

class MyListStationAdapter(private var stationList: List<MyListStation>):
    RecyclerView.Adapter<MyListStationAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val stationName: TextView = itemView.findViewById(R.id.station_text)
        val direction: TextView = itemView.findViewById(R.id.direction_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.my_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.stationName.text = stationList[position].stationName
        holder.direction.text = stationList[position].direction
    }

    override fun getItemCount(): Int {
        return stationList.size
    }

}