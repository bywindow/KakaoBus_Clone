package com.example.kakaobus_clone

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private val args: TimelinesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBusBinding.inflate(inflater, container, false)
        busListViewModel = ViewModelProvider(requireActivity(), BottomSheetAddBusViewModel.Factory(
            Application()
        )).get(BottomSheetAddBusViewModel::class.java)

        subscribeUi()

        return binding.root
    }

    private fun subscribeUi() {
        addBusAdapter = BottomSheetAddBusAdapter().apply { setHasStableIds(true) }
        binding.bottomSheetBusListRecyclerview.adapter = addBusAdapter

        binding.bottomSheetStationName.text = args.station.stationName
        binding.bottomSheetDirection.text = args.station.direction
    }
}