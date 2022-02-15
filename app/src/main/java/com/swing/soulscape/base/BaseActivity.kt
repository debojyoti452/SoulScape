package com.swing.soulscape.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity(), BaseInterface {

    open fun vmObserver() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vmObserver()
    }

    override fun showLog(msg: Any) {
        Timber.d(msg.toString())
    }
}
