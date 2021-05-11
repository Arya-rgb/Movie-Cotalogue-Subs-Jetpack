package com.thorin.moviecotalogue.ui.detail.detailtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.vo.Resource

class DetailTvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    val tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var tvData: LiveData<Resource<TvShowEntity>> =
        Transformations.switchMap(tvShowId) { mTvShowId ->
            filmRepository.getTvShowDetail(mTvShowId)
        }

    fun getTvShowForTest(movieId: String): LiveData<TvShowEntity> =
        filmRepository.getDetailTvShowById(movieId)

    fun setTvShowFav() {
        val tvResource = tvData.value
        if (tvResource != null) {
            val detailTvShow = tvResource.data

            if (detailTvShow != null) {
                val newState = !detailTvShow.favorite
                filmRepository.setTvShowFavorite(detailTvShow, newState)
            }
        }
    }

}