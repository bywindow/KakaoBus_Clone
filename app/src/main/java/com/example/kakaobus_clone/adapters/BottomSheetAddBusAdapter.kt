package com.example.kakaobus_clone.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.RouteByStationComponent
import com.example.kakaobus_clone.data.models.RouteByStation
import com.example.kakaobus_clone.databinding.BottomSheetBusListBinding
import com.example.kakaobus_clone.databinding.BottomSheetHeaderBusTypeBinding

class BottomSheetAddBusAdapter(routeByStation: RouteByStation) : RecyclerView.Adapter<BottomSheetAddBusAdapter.ViewHolder>() {

    private var items = routeByStation
    private val TYPE_HEADER: Int = 0
    private val TYPE_ITEM: Int = 1

    class ViewHolder(
        private val binding: BottomSheetBusListBinding
    ): RecyclerView.ViewHolder(binding.root) {

        var isStarred : MutableMap<String, Boolean> = mutableMapOf( "0" to false)

        init {
            binding.setClickListener { view ->
                Log.d("arsId", isStarred.entries.toString())
                var cur = isStarred.getOrDefault(binding.bottomSheetBusNumberTextView.text, false)
                isStarred[binding.bottomSheetBusNumberTextView.text.toString()] = !cur
            }
        }

        fun bind(item: RouteByStationComponent, flag: Boolean) {
            binding.bottomSheetBusNumberTextView.text = item.busRouteNm
            if (!flag) binding.bottomSheetBusSelectButton.setBackgroundResource(R.drawable.ic_circle_add)
            else binding.bottomSheetBusSelectButton.setBackgroundResource(R.drawable.ic_check)
        }

    }

    class HeaderViewHolder(
        private val binding: BottomSheetHeaderBusTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

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
        holder.bind(items.data.routes[position], holder.isStarred.getOrDefault(items.data.routes[position].busRouteNm, false))
    }

    override fun getItemCount(): Int = items.data.routes.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
}