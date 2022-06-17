package com.example.foodish.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * Its a progressbar observable.
     */
    protected val mProgress = MutableLiveData<PageState>()
    val progress: LiveData<PageState>
        get() = mProgress

    /**
     * Its a progressbar observable.
     */
    protected val mUploadingProgress = MutableLiveData<PageState>()
    val uploadingProgress: LiveData<PageState>
        get() = mUploadingProgress

    /*
   * Used to show the error message from failure, through snack bar.
   */
    protected val mError = MutableLiveData<Event<Exception>>()
    val error: LiveData<Event<Exception>>
        get() = mError

    /*
   * Used to show the error message from failure, through snack bar.
   */
    protected val _nError = MutableLiveData<String>()
    val nError: LiveData<String>
        get() = _nError

    /*
    * Used to show the error message from failure, through snack bar.
    */
    protected val mMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = mMessage

    /*
   * Used to show the error message from failure, through toast.
   */
    protected val mToast = MutableLiveData<Event<String>>()
    val toast: LiveData<Event<String>>
        get() = mToast


    protected fun showProgress() {
        mProgress.value = PageState.LOADING
    }

    protected fun hideProgress() {
        mProgress.value = PageState.LOADED
    }

    protected fun showUploadingProgress() {
        mUploadingProgress.value = PageState.LOADING
    }

    protected fun hideUploadingProgress() {
        mUploadingProgress.value = PageState.LOADED
    }
}
