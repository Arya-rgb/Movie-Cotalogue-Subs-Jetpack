package com.thorin.moviecotalogue.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.databinding.ItemsTvshowBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShowEntity>()

    class TvShowViewHolder(private val itemsTvShowBinding: ItemsTvshowBinding) :
        RecyclerView.ViewHolder(itemsTvShowBinding.root) {

        fun bind(tvShow: TvShowEntity) {
            with(itemsTvShowBinding) {
                tvShowName.text = tvShow.tvShowName
                tvShowRelease.text = tvShow.tvShowRelease
                tvShowRate.text = tvShow.tvShowRate
                tvShowDescription.text = tvShow.tvShowDescription
                tvShowGenre.text = tvShow.tvShowGenre
                tvShowLocation.text = tvShow.tvShowLocation
                tvShowTotalEpisode.text = tvShow.tvShowTotalEpisode
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher_round)
                    )
                    .into(imgPoster)
            }
        }

    }

    fun setTvShow(tvShow: List<TvShowEntity>?) {
        if (null == tvShow) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

}