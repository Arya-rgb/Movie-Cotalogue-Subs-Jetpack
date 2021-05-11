package com.thorin.moviecotalogue.ui.detail.detailtvshow

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
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.databinding.ActivityDetailTvShowBinding
import com.thorin.moviecotalogue.databinding.ContentDetialTvshowBinding
import com.thorin.moviecotalogue.viewmodel.ViewModelFactory
import com.thorin.moviecotalogue.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var contentDetailBinding: ContentDetialTvshowBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(activityDetailTvShowBinding.root)
        contentDetailBinding = activityDetailTvShowBinding.contentTvShow

        setSupportActionBar(activityDetailTvShowBinding.toolbar)


        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this)
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (null != extras) {
            val tvShowId = extras.getString(EXTRA_TV)
            if (null != tvShowId) {
                viewModel.setSelectedTvShow(tvShowId)

                viewModel.tvData.observe(this, { tvShow ->
                    if (tvShow != null) {
                        when (tvShow.status) {
                            Status.LOADING -> {
                                activityDetailTvShowBinding.progressBar2.visibility = View.VISIBLE
                                activityDetailTvShowBinding.fabFavorite.visibility = View.INVISIBLE
                                activityDetailTvShowBinding.fab.visibility = View.INVISIBLE
                                activityDetailTvShowBinding.contentForTv.visibility = View.INVISIBLE
                            }
                            Status.SUCCESS -> if (tvShow.data != null) {
                                activityDetailTvShowBinding.progressBar2.visibility = View.GONE
                                activityDetailTvShowBinding.contentForTv.visibility = View.VISIBLE
                                activityDetailTvShowBinding.fabFavorite.visibility = View.VISIBLE
                                activityDetailTvShowBinding.fab.visibility = View.VISIBLE
                                val state = tvShow.data.favorite
                                setBookmarkState(state)

                                populateTvShow(tvShow.data)
                            }
                            Status.ERROR -> {
                                activityDetailTvShowBinding.progressBar2.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                    activityDetailTvShowBinding.fabFavorite.setOnClickListener {
                        viewModel.setTvShowFav()
                    }

                })
            }
        }
    }

    private fun setBookmarkState(state: Boolean) {
        if (state) {
            activityDetailTvShowBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_24
                )
            )
        } else {
            activityDetailTvShowBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_unfavorite_border_24
                )
            )
        }
    }


    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        contentDetailBinding.tvShowName.text = tvShowEntity.tvShowName
        contentDetailBinding.tvShowReleaseDetail.text = tvShowEntity.tvShowRelease
        contentDetailBinding.tvShowRateDetail.text = tvShowEntity.tvShowRate
        contentDetailBinding.tvShowDescDetail.text = tvShowEntity.tvShowDescription
        contentDetailBinding.tvShowGenreDetail.text = tvShowEntity.tvShowGenre
        contentDetailBinding.tvShowLocationDetail.text = tvShowEntity.tvShowLocation
        contentDetailBinding.tvShowTotalEpisodeDetail.text = tvShowEntity.tvShowTotalEpisode

        activityDetailTvShowBinding.toolbarLayout.title = tvShowEntity.tvShowName

        Glide.with(this)
            .load(tvShowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loader).error(R.drawable.ic_error))
            .into(activityDetailTvShowBinding.imagePosterDetailTv)

        activityDetailTvShowBinding.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareBody =
                "${resources.getString(R.string.share_body1)} ${
                    contentDetailBinding.tvShowName.text
                }, ${resources.getString(R.string.share_body2)} ${contentDetailBinding.tvShowRateDetail.text}, ${
                    resources.getString(
                        R.string.share_body3
                    )
                }"
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, contentDetailBinding.tvShowName.text)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, resources.getString(R.string.share_title)))
        }

    }
}