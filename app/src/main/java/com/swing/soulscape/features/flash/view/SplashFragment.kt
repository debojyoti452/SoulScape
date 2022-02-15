package com.swing.soulscape.features.flash.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun vmObserver() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }
}
