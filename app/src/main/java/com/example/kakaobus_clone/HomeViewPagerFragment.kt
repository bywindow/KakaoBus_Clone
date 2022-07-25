package com.example.kakaobus_clone

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kakaobus_clone.adapters.HelpBannerAdapter
import com.example.kakaobus_clone.data.assets.HelpBannerSample
import com.example.kakaobus_clone.data.models.HelpBanner
import com.example.kakaobus_clone.databinding.FragmentViewPagerBinding

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val viewPager = binding.cardViewPager

        viewPager.adapter = HelpBannerAdapter(HelpBannerSample())
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_timeline, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refactor -> {
                Log.d("DEBUG","press 편집")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}