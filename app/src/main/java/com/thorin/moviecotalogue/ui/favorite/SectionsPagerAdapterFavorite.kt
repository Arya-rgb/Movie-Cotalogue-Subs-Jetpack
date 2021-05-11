package com.thorin.moviecotalogue.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.ui.favorite.movie.MovieFragmentFavorite
import com.thorin.moviecotalogue.ui.favorite.tvshow.TvShowFragmentFavorite

class SectionsPagerAdapterFavorite(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val tabTitles = intArrayOf(R.string.movie, R.string.tv_Show)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragmentFavorite()
            1 -> TvShowFragmentFavorite()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(tabTitles[position])
}