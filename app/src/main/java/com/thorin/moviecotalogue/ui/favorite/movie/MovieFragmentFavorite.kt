package com.thorin.moviecotalogue.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thorin.moviecotalogue.databinding.FragmentMovieFavoriteBinding
import com.thorin.moviecotalogue.ui.movie.MovieAdapter
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory


class MovieFragmentFavorite : Fragment() {

    private lateinit var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavoriteBinding =
            FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel =
            ViewModelProvider(
                this,
                ViewModelFactory.getInstance(requireActivity())
            )[MovieFragmentFavViewModel::class.java]

        val movieAdapter = MovieAdapter()

        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            movieAdapter.submitList(movies)
            movieAdapter.notifyDataSetChanged()
        })

        with(fragmentMovieFavoriteBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}