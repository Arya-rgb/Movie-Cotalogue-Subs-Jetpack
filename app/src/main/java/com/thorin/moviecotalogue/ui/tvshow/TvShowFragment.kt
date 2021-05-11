package com.thorin.moviecotalogue.ui.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thorin.moviecotalogue.databinding.FragmentTvShowBinding
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory
import com.thorin.moviecotalogue.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (null != activity) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelFactory.getInstance(requireActivity())
            )[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when(tvShow.status) {
                        Status.LOADING -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            tvShowAdapter.submitList(tvShow.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvshow) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }

        }
    }

}