package com.swing.soulscape.features.flash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.swing.soulscape.R
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentGetStartedBinding
import com.swing.soulscape.features.flash.viewmodel.GetStartedViewModel
import com.swing.soulscape.utils.Extensions.logoRotate

class GetStartedFragment : BaseFragment<FragmentGetStartedBinding>(), View.OnClickListener {

    private val getStartedVM: GetStartedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.innerLogoGetStarted.flashImg.logoRotate()
        binding.startUrJourneyBtn.setOnClickListener(this)
        binding.iAlreadyHaveBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.startUrJourneyBtn -> {

            }

            R.id.iAlreadyHaveBtn -> {

            }
        }
    }

    override fun vmObserver() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetStartedBinding {
        return FragmentGetStartedBinding.inflate(inflater, container, false)
    }
}
