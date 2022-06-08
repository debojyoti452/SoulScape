package com.swing.soulscape.features.prefer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.swing.soulscape.adapter.PreferImageViewAdapter
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentPreferBinding
import com.swing.soulscape.db.LocalDb
import com.swing.soulscape.utils.Extensions.logoRotate

class PreferFragment : BaseFragment<FragmentPreferBinding>() {

    private val adapter = PreferImageViewAdapter(
        imageList = LocalDb.generatePreferList()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logo.flashImg.logoRotate()

        binding.topImageViewPager.adapter = adapter

        binding.topImageViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

            }
        })
    }

    override fun vmObserver() {

    }

    override fun onDeviceBack() {
        requireActivity().finish()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPreferBinding {
        return FragmentPreferBinding.inflate(inflater, container, false)
    }
}
