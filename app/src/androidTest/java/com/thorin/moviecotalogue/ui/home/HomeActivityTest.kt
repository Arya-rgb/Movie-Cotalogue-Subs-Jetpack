package com.thorin.moviecotalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.thorin.moviecotalogue.R
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val dataHelperMovie = DataHelper.generateDataMovie()
    private val dataHelperTvShow = DataHelper.generateDataTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    /*
    loadMovie() -> membuka rv movie, check apakah tampil lalu perfom scroll sesuai dengan ukuran dari
    generateDataMovie()
     */

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dataHelperMovie.size
            )
        )
    }

    /*
    loadTvShow() -> Menklik teks yang terdapat TV SHOW(untuk pindah fragment)
    lalu check apakah tampil dan scroll postition to sesuai size dari generateDataTvShow()
     */

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dataHelperTvShow.size
            )
        )
    }

    /*
    loadDetailMovie() -> menklik posisi rv pertama lalu mencek apakah tampil
    - mencek value antara ui dan datahelper apakah sama

     */

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_poster_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.movieName)).check(matches(isDisplayed()))
        onView(withId(R.id.movieName)).check(matches(withText(dataHelperMovie[0].movieName)))
        onView(withId(R.id.movieRelease_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRelease_detail)).check(matches(withText(dataHelperMovie[0].movieRelease)))
        onView(withId(R.id.movieRate_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRate_detail)).check(matches(withText(dataHelperMovie[0].movieRate)))
        onView(withId(R.id.movieDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDescription)).check(matches(withText(dataHelperMovie[0].movieDescription)))
        //onView(withId(R.id.movieGenre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.movieGenre_detail)).check(matches(withText(dataHelperMovie[0].movieGenre)))
        //onView(withId(R.id.movieLocation)).check(matches(isDisplayed()))
        onView(withId(R.id.movieLocation)).check(matches(withText(dataHelperMovie[0].movieLocation)))

    }

    /*
     loadDetailTvShow() -> pindah fragment ke TV SHOW dengan menklik teks yang terdapat TV SHOW
    -mencek antara value ui dan datahelper apakah sama
     */

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_poster_detail_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowName)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowName)).check(matches(withText(dataHelperTvShow[0].tvShowName)))
        onView(withId(R.id.tvShowRelease_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowRelease_detail)).check(matches(withText(dataHelperTvShow[0].tvShowRelease)))
        onView(withId(R.id.tvShowRate_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowRate_detail)).check(matches(withText(dataHelperTvShow[0].tvShowRate)))
        onView(withId(R.id.tvShowDescDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDescDetail)).check(matches(withText(dataHelperTvShow[0].tvShowDescription)))
        //onView(withId(R.id.tvShowGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowGenreDetail)).check(matches(withText(dataHelperTvShow[0].tvShowGenre)))
        //onView(withId(R.id.tvShowLocationDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowLocationDetail)).check(matches(withText(dataHelperTvShow[0].tvShowLocation)))
        //onView(withId(R.id.tvShowTotalEpisodeDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowTotalEpisodeDetail)).check(matches(withText(dataHelperTvShow[0].tvShowTotalEpisode)))
    }

}