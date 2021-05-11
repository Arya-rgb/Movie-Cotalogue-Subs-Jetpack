package com.thorin.moviecotalogue.ui.favorite.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thorin.moviecotalogue.databinding.FragmentTvShowFavoriteBinding
import com.thorin.moviecotalogue.ui.tvshow.TvShowAdapter
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory


class TvShowFragmentFavorite : Fragment() {

    private lateinit var fragmentTvShowFavoriteBinding: FragmentTvShowFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowFavoriteBinding =
            FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel =
            androidx.lifecycle.ViewModelProvider(
                this,
                ViewModelFactory.getInstance(requireActivity())
            )[TvShowFavViewModel::class.java]

        val tvShowAdapter = TvShowAdapter()
        viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
            tvShowAdapter.submitList(tvShow)
            tvShowAdapter.notifyDataSetChanged()
        })

        with(fragmentTvShowFavoriteBinding.rvTvshow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }

    }

}