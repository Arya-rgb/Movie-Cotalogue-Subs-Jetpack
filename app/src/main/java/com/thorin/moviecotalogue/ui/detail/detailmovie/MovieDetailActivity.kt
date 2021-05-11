package com.thorin.moviecotalogue.ui.detail.detailmovie

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.databinding.ActivityMovieDetailBinding
import com.thorin.moviecotalogue.databinding.ContentDetailMovieBinding
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory
import com.thorin.moviecotalogue.vo.Status

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

        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this)
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (null != extras) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (null != movieId) {
                viewModel.setSelectedMovie(movieId)


                viewModel.movieData.observe(this, { movie ->

                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> {
                                activityMovieDetailBinding.progressBar2.visibility = View.VISIBLE
                                activityMovieDetailBinding.fab.visibility = View.INVISIBLE
                                activityMovieDetailBinding.fabFavorite.visibility = View.INVISIBLE
                                activityMovieDetailBinding.contentForMovie.visibility =
                                    View.INVISIBLE
                            }
                            Status.SUCCESS -> if (movie.data != null) {
                                activityMovieDetailBinding.progressBar2.visibility = View.GONE
                                activityMovieDetailBinding.contentForMovie.visibility = View.VISIBLE
                                activityMovieDetailBinding.fab.visibility = View.VISIBLE
                                activityMovieDetailBinding.fabFavorite.visibility = View.VISIBLE
                                val state = movie.data.favorite
                                setBookmarkState(state)
                                populateMovie(movie.data)

                            }
                            Status.ERROR -> {
                                activityMovieDetailBinding.progressBar2.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                    //add to favorite
                    activityMovieDetailBinding.fabFavorite.setOnClickListener {
                        viewModel.setFavorite()
                    }
                })
            }
        }
    }

    private fun setBookmarkState(state: Boolean) {
        if (state) {
            activityMovieDetailBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_24
                )
            )
        } else {
            activityMovieDetailBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_unfavorite_border_24
                )
            )
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.movieName.text = movieEntity.movieName
        detailContentBinding.movieReleaseDetail.text = movieEntity.movieRelease
        detailContentBinding.movieRateDetail.text = movieEntity.movieRate
        detailContentBinding.movieDescription.text = movieEntity.movieDescription
        detailContentBinding.movieGenreDetail.text = movieEntity.movieGenre
        detailContentBinding.movieLocation.text = movieEntity.movieLocation
        activityMovieDetailBinding.toolbarLayout.title = movieEntity.movieName

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loader).error(R.drawable.ic_error))
            .into(activityMovieDetailBinding.imagePosterDetail)

        activityMovieDetailBinding.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareBody =
                "${resources.getString(R.string.share_body1)} ${
                    detailContentBinding.movieName.text
                }, ${resources.getString(R.string.share_body2)} ${detailContentBinding.movieRateDetail.text}, ${
                    resources.getString(
                        R.string.share_body3
                    )
                }"
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, detailContentBinding.movieName.text)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, resources.getString(R.string.share_title)))
        }


    }

}