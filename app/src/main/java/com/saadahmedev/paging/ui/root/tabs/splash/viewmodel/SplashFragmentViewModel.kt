package com.saadahmedev.paging.ui.root.tabs.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saadahmedev.paging.helper.delay
import com.saadahmedev.paging.util.AppConstants

class SplashFragmentViewModel : ViewModel() {

    private val _onSplashComplete = MutableLiveData<Boolean>()
    val onSplashComplete: LiveData<Boolean>
        get() = _onSplashComplete

    fun start() {
        startSplash()
    }

    private fun startSplash() {
        delay(AppConstants.SPLASH_SCREEN_TIME) {
            _onSplashComplete.postValue(true)
        }
    }
}