package com.thorin.moviecotalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.di.Injection
import com.thorin.moviecotalogue.ui.detail.detailmovie.DetailMovieViewModel
import com.thorin.moviecotalogue.ui.detail.detailtvshow.DetailTvShowViewModel
import com.thorin.moviecotalogue.ui.movie.MovieViewModel
import com.thorin.moviecotalogue.ui.tvshow.TvShowViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val mFilmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory() {

  companion object{
      @Volatile
      private var instance: ViewModelFactory? = null

      fun getInstance(context: Context): ViewModelFactory =
          instance ?: synchronized(this) {
              instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                  instance = this
              }
          }
  }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }

    }

}