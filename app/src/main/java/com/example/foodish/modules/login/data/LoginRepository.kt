package com.example.foodish.modules.login.data

import com.example.foodish.network.request.LoginRequest


/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository() {

    /**
     * Performs the login
     */
    fun login(request: LoginRequest): Boolean {
            return true
        }
}