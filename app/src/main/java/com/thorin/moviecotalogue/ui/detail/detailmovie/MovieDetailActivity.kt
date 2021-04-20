package com.thorin.moviecotalogue.ui.detail.detailmovie

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.databinding.ActivityMovieDetailBinding
import com.thorin.moviecotalogue.databinding.ContentDetailMovieBinding

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityMovieDetailBinding: ActivityMovieDetailBinding
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(activityMovieDetailBinding.root)

        detailContentBinding = activityMovieDetailBinding.detailMovie

        setSupportActionBar(activityMovieDetailBinding.toolbar)

        activityMovieDetailBinding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (null != extras) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (null != movieId) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie() as MovieEntity)
            }
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.movieName.text = movieEntity.movieName
        detailContentBinding.movieReleaseDetail.text = movieEntity.movieRelease
        detailContentBinding.movieRateDetail.text = movieEntity.movieRate
        detailContentBinding.movieDescription.text = movieEntity.movieDescription
        detailContentBinding.movieGenre.text = movieEntity.movieGenre
        detailContentBinding.movieLocation.text = movieEntity.movieLocation

        activityMovieDetailBinding.toolbarLayout.title = movieEntity.movieName

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher))
            .into(activityMovieDetailBinding.imagePosterDetail)
    }
}