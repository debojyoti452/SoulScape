package com.swing.soulscape.features.flash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swing.soulscape.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashViewModel @Inject constructor() : BaseViewModel<FlashViewModel>() {

    private val _splashScreen = MutableLiveData(false)
    val splashScreenTrans: LiveData<Boolean> = _splashScreen

    fun flashScreenChange() {
        _splashScreen.value = true
    }
}
