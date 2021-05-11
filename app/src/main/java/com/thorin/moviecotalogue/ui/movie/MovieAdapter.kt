package com.thorin.moviecotalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.databinding.ItemsMovieBinding
import com.thorin.moviecotalogue.ui.detail.detailmovie.MovieDetailActivity

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

//    private var listMovie = ArrayList<MovieEntity>()

    class MovieViewHolder(private val itemsMovieBinding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(itemsMovieBinding.root) {
        fun bind(movie: MovieEntity) {
            with(itemsMovieBinding) {
                movieName.text = movie.movieName
                movieRelease.text = movie.movieRelease
                movieRate.text = movie.movieRate
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loader)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

}