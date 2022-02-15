package com.swing.soulscape.features.flash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashViewModel @Inject constructor() : ViewModel() {

    private val _splashScreen = MutableLiveData(false)
    val splashScreenTrans: LiveData<Boolean> = _splashScreen

    fun flashScreenChange() {
        _splashScreen.value = true
    }
}
