package com.swing.soulscape.features.prefer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.swing.soulscape.adapter.PreferImageViewAdapter
import com.swing.soulscape.adapter.PreferListAdapter
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentPreferBinding
import com.swing.soulscape.db.LocalDb
import com.swing.soulscape.features.custom_view.DepthPageTransformer
import com.swing.soulscape.utils.Extensions.logoRotate

class PreferFragment : BaseFragment<FragmentPreferBinding>() {

    private val adapter = PreferImageViewAdapter(
        imageList = LocalDb.generatePreferList()
    )

    private val listAdapter = PreferListAdapter(
        dataList = LocalDb.generatePreferList().toMutableList()
            .subList(1, LocalDb.generatePreferList().size),
        listener = {
            binding.topImageViewPager.currentItem = it + 1
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logo.flashImg.logoRotate()
        binding.topImageViewPager.adapter = adapter
        binding.topImageViewPager.setPageTransformer(DepthPageTransformer())
        binding.topImageViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

            }
        })

        binding.itemListView.layoutManager = LinearLayoutManager(context)
        binding.itemListView.adapter = listAdapter
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
