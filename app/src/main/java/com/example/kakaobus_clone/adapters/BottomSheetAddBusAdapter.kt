package com.example.kakaobus_clone.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.RouteByStationComponent
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.data.models.RouteByStationList
import com.example.kakaobus_clone.databinding.BottomSheetBusListBinding

class BottomSheetAddBusAdapter: RecyclerView.Adapter<BottomSheetAddBusAdapter.ViewHolder>() {

    private var items : RouteByStation = RouteByStation(RouteByStationList(ArrayList()))
    private val TYPE_HEADER: Int = 0
    private val TYPE_ITEM: Int = 1

    // 즐겨찾기 배열 : items 길이만큼 초기화
    private var isStarred = MutableList<Boolean>(items.data.routes.size) { false }

    class ViewHolder(
        private val binding: BottomSheetBusListBinding
    ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->

            }
        }

        fun bind(item: RouteByStationComponent, flag: Boolean) {
            binding.bottomSheetBusNumberTextView.text = item.busRouteNm
            if (!flag) binding.bottomSheetBusSelectButton.setImageResource(R.drawable.ic_circle_add)
            else binding.bottomSheetBusSelectButton.setImageResource(R.drawable.ic_check)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.bottom_sheet_bus_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.data.routes[position], isStarred[position])
    }

    override fun getItemCount(): Int = items.data.routes.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
}