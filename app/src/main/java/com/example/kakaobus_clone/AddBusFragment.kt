package com.example.kakaobus_clone

import android.app.Application
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
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
        viewModel.starredRoute.observe(this) { star ->
            Log.d("arsId", "change")
            viewModel.typedRoute.value?.let { type ->
                (0..10).forEach { i ->
                    if (type.containsKey(i.toString())) {
                        val busTypeView = LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet_header_bus_type, null, false)
                        busTypeView.findViewById<TextView>(R.id.bottom_sheet_bus_type_textView).text = viewModel.busTypes[i]
                        busListLinearLayout.addView(busTypeView)
                        val routes = type[i.toString()]?.split("\n")
                        routes?.subList(1, routes.size)?.forEach { it ->
                            Log.d("arsId", it)
                            val busListView = LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet_bus_list, null, false)
                            busListView.findViewById<TextView>(R.id.bottom_sheet_bus_number_textView).text = it
                            busListView.findViewById<AppCompatImageButton>(R.id.bottom_sheet_bus_select_button).setOnClickListener { btn ->
                                viewModel.addBusButtonClicked(it)
                                if (star.get(it.toString()) == true) {
                                    Toast.makeText(requireContext(), "즐겨찾기가 제거되었습니다.", Toast.LENGTH_SHORT).show()
                                } else {
                                    busListView.findViewById<AppCompatImageButton>(R.id.bottom_sheet_bus_select_button).setBackgroundResource(R.drawable.ic_check)
                                    Toast.makeText(requireContext(), "즐겨찾기가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                            when (i) {
                                3 -> busListView.findViewById<TextView>(R.id.bottom_sheet_bus_number_textView).setTextColor(Color.BLUE)
                                else -> busListView.findViewById<TextView>(R.id.bottom_sheet_bus_number_textView).setTextColor(Color.RED)
                            }
                            busListLinearLayout.addView(busListView)
                        }
                    }
                }
            }
        }
        binding.bottomSheetStationName.text = args.station.stationName
        binding.bottomSheetDirection.text = args.station.direction
    }
}