package com.thorin.moviecotalogue.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thorin.moviecotalogue.databinding.FragmentMovieBinding
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (null != activity) {

            val viewModel = ViewModelProvider(
                this,
                ViewModelFactory.getInstance(requireActivity())
            )[MovieViewModel::class.java]
            val movies = viewModel.getMovie()

            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(movies)

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}