package com.example.kakaobus_clone

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
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
        val cardViewPager = binding.cardViewPager
        val menuHost: MenuHost = requireActivity()

        cardViewPager.adapter = HelpBannerAdapter(HelpBannerSample())
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        initMenu(menuHost)

        return binding.root
    }

    private fun initMenu(menuHost: MenuHost) {
        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_timeline, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_refactor -> {
                        Log.d("DEBUG","press 편집")
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}