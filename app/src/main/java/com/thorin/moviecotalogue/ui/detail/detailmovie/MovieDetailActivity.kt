package com.thorin.moviecotalogue.ui.detail.detailmovie

import android.content.Intent
import android.os.Bundle
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

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (null != extras) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (null != movieId) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }
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