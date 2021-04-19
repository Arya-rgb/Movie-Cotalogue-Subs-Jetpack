package com.thorin.moviecotalogue.ui.movie

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.databinding.ItemsMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<MovieEntity>()

    class MovieViewHolder(private val itemsMovieBinding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(itemsMovieBinding.root) {
        fun bind(movie: MovieEntity) {
            with(itemsMovieBinding) {
                movieName.text = movie.movieName
                movieRelease.text = movie.movieRelease
                movieRate.text = movie.movieRate
                movieDescription.text = movie.movieDescription
                movieGenre.text = movie.movieGenre
                movieLocation.text = movie.movieLocation
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher_round)
                    )
                    .into(imgPoster)
            }
        }
    }

    fun setMovies(movies: List<MovieEntity>?) {
        if (null == movies) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovie.size
}