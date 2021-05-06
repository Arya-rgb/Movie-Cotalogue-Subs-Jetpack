package com.thorin.moviecotalogue.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

import com.thorin.moviecotalogue.databinding.ActivitySplashBinding
import com.thorin.moviecotalogue.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var splashActivityBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivityBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashActivityBinding.root)

        supportActionBar?.hide()

        YoYo.with(Techniques.Bounce)
            .duration(7000)
            .playOn(splashActivityBinding.logo)

        YoYo.with(Techniques.FadeInUp)
            .duration(5000) // Time it for app name to fade in up
            .playOn(splashActivityBinding.appname)

        Handler(Looper.getMainLooper()).postDelayed({
            val myIntent = Intent(this, HomeActivity::class.java)
            startActivity(myIntent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            finish()
        }, 3000)
    }

}