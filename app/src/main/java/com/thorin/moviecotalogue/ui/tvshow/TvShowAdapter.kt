package com.thorin.moviecotalogue.ui.tvshow

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.databinding.ItemsTvshowBinding
import com.thorin.moviecotalogue.ui.detail.detailtvshow.DetailTvShowActivity

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    class TvShowViewHolder(private val itemsTvShowBinding: ItemsTvshowBinding) :
        RecyclerView.ViewHolder(itemsTvShowBinding.root) {

        fun bind(tvShow: TvShowEntity) {
            with(itemsTvShowBinding) {
                tvShowName.text = tvShow.tvShowName
                tvShowRelease.text = tvShow.tvShowRelease
                tvShowRate.text = tvShow.tvShowRate
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loader)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }

            }
        }

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
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }



}