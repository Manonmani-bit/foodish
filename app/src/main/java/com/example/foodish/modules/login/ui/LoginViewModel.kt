package com.example.foodish.modules.login.ui.ui.login

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.example.foodish.R
import com.example.foodish.common.BaseApplication
import com.example.foodish.common.BaseViewModel
import com.example.foodish.common.ErrorMessage
import com.example.foodish.modules.login.data.LoginRepository
import com.example.foodish.network.request.LoginRequest

class LoginViewModel(application: Application) : BaseViewModel(application) {

    val userName = MutableLiveData<String>().apply {
        postValue(null)
    }
    val password = MutableLiveData<String>().apply {
        postValue(null)
    }
    val userNameErrorText = MutableLiveData<String>().apply {
        postValue(null)
    }
    val passwordErrorText = MutableLiveData<String>().apply {
        postValue(null)
    }
    val nextScreen = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<ErrorMessage>()
    private val loginRepository = LoginRepository()


    fun validate() {
        if (isUseNameValid() && isPasswordValid()) {
            login()
        } else{}
    }

    /**
     * Login API implementation
     */
    fun login() {
        showProgress()
        val loginRequest = LoginRequest()
        loginRequest.USerName = userName.value
        loginRequest.Password = password.value
        nextScreen.value = loginRepository.login(loginRequest)
    }
    /**
     * Check password is valid or not
     */
    private fun isPasswordValid(): Boolean {
        return if (TextUtils.isEmpty(password.value)) {
            passwordErrorText.value = BaseApplication.applicationContext()
                .getString(R.string.error_please_enter_password)
            true
        } else {
            true
        }
    }

    /**
     * Check password is valid or not
     */
    private fun isUseNameValid(): Boolean {
        return if (TextUtils.isEmpty(userName.value)) {
            userNameErrorText.value =
                BaseApplication.applicationContext()
                    .getString(R.string.error_please_enter_user_name)
            true
        } else {
            true
        }
    }

}