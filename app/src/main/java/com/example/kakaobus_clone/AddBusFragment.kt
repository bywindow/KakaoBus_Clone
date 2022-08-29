package com.example.kakaobus_clone

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.kakaobus_clone.adapters.BottomSheetAddBusAdapter
import com.example.kakaobus_clone.databinding.FragmentAddBusBinding
import com.example.kakaobus_clone.viewmodels.BottomSheetAddBusViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddBusFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddBusBinding
    private lateinit var busListViewModel: BottomSheetAddBusViewModel
    private lateinit var addBusAdapter: BottomSheetAddBusAdapter
    private lateinit var busListLinearLayout: LinearLayout
    private val args: AddBusFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_KakaoBus_Clone_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBusBinding.inflate(inflater, container, false)
        busListViewModel = ViewModelProvider(requireActivity(), BottomSheetAddBusViewModel.Factory(
            Application()
        )).get(BottomSheetAddBusViewModel::class.java)
        busListLinearLayout = binding.busListLinearLayout

        subscribeUi(binding, busListViewModel)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentAddBusBinding, viewModel: BottomSheetAddBusViewModel) {
        viewModel.routeList.observe(this) {
            viewModel.routeList.value?.let {
//                addBusAdapter = BottomSheetAddBusAdapter(it).apply { setHasStableIds(true) }
//                binding.bottomSheetBusListRecyclerview.adapter = addBusAdapter
                it.data.routes.forEach {
                    val busListView = LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet_bus_list, null, false)
                    busListView.findViewById<TextView>(R.id.bottom_sheet_bus_number_textView).text = it.busRouteNm
                    busListLinearLayout.addView(busListView)
                }
            }
        }
        binding.bottomSheetStationName.text = args.station.stationName
        binding.bottomSheetDirection.text = args.station.direction
    }
}