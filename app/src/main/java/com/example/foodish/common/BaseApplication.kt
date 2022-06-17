package com.example.foodish.common

import android.app.Application
import android.content.Context

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        private lateinit var instance: BaseApplication

        fun getInstance(): BaseApplication {
            if (instance == null) {
                // This should always be a dead code.
                instance = BaseApplication()
            }
            return instance
        }

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }
}
