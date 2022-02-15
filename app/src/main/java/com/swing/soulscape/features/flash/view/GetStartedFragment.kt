package com.swing.soulscape.features.flash.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentGetStartedBinding

class GetStartedFragment : BaseFragment<FragmentGetStartedBinding>() {
    override fun vmObserver() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetStartedBinding {
        return FragmentGetStartedBinding.inflate(inflater, container, false)
    }
}
