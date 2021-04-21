package com.thorin.moviecotalogue.ui.detail.detailtvshow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.databinding.ActivityDetailTvShowBinding
import com.thorin.moviecotalogue.databinding.ContentDetialTvshowBinding

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var contentDetailBinding: ContentDetialTvshowBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailTvShowBinding.root)


        contentDetailBinding = detailTvShowBinding.contentTvShow

        setSupportActionBar(detailTvShowBinding.toolbar)


        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (null != extras) {
            val tvShowId = extras.getString(EXTRA_TV)
            if (null != tvShowId) {
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow())
            }
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

        detailTvShowBinding.toolbarLayout.title = tvShowEntity.tvShowName

        Glide.with(this)
            .load(tvShowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loader).error(R.drawable.ic_error))
            .into(detailTvShowBinding.imagePosterDetailTv)

        detailTvShowBinding.fab.setOnClickListener {
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