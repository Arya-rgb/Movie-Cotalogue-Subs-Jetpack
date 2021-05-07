package com.thorin.moviecotalogue.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.databinding.FragmentFavoriteBinding
import com.thorin.moviecotalogue.databinding.FragmentHomeBinding
import com.thorin.moviecotalogue.ui.home.ui.dashboard.DashboardViewModel


class FavoriteFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapterFavorite(view.context, childFragmentManager)
        fragmentFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        fragmentFavoriteBinding.tabs.setupWithViewPager(fragmentFavoriteBinding.viewPager)
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }


}