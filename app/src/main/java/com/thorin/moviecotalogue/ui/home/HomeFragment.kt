package com.thorin.moviecotalogue.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.thorin.moviecotalogue.databinding.FragmentHomeBinding
import com.thorin.moviecotalogue.ui.home.SectionsPagerAdapter


class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(view.context, childFragmentManager)
        homeFragmentBinding.viewPager.adapter = sectionsPagerAdapter
        homeFragmentBinding.tabs.setupWithViewPager(homeFragmentBinding.viewPager)
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }

}
