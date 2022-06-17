package com.example.foodish.modules.splash.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.foodish.R
import com.example.foodish.modules.login.ui.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        launchWithDelay()
    }

    private fun launchWithDelay() {
        Handler().postDelayed({ launchLoginScreen() }, SPLASH_DELAY.toLong())
    }

    private fun launchLoginScreen() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }

    companion object {
        val SPLASH_DELAY = 2000
    }
}