package com.swing.soulscape.features.flash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentSplashBinding
import com.swing.soulscape.features.flash.viewmodel.SplashViewModel
import com.swing.soulscape.utils.Extensions.logoRotate

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.splashLogo.flashImg.logoRotate()
    }

    override fun vmObserver() {

    }

    override fun onDeviceBack() {
        requireActivity().finish()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }
}
