package com.swing.soulscape.features.prefer.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentPreferBinding

class PreferFragment : BaseFragment<FragmentPreferBinding>() {
    override fun vmObserver() {

    }

    override fun onDeviceBack() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPreferBinding {
        return FragmentPreferBinding.inflate(inflater, container, false)
    }
}
