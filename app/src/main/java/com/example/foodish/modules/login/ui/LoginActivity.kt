package com.example.foodish.modules.login.ui.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodish.R
import com.example.foodish.databinding.ActivityLoginBinding
import com.example.foodish.modules.home.breed.data.ui.HomeActivity

class LoginActivity : AppCompatActivity() {

    private val loginViewModel by lazy {
        ViewModelProvider(
            this
        ).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        initObervers()

    }

    private fun initObervers() {
        loginViewModel.nextScreen.observe(this@LoginActivity, Observer {
            if (it) {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        })
    }

}