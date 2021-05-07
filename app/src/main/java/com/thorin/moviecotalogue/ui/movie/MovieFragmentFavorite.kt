package com.thorin.moviecotalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thorin.moviecotalogue.databinding.FragmentMovieFavoriteBinding


class MovieFragmentFavorite : Fragment() {

    private lateinit var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }
}