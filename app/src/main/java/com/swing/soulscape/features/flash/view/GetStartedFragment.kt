package com.swing.soulscape.features.flash.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lib.StarWars
import com.swing.soulscape.R
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentGetStartedBinding
import com.swing.soulscape.features.auth.AuthActivity
import com.swing.soulscape.features.flash.viewmodel.GetStartedViewModel
import com.swing.soulscape.utils.Extensions.logoRotate
import com.swing.soulscape.utils.Extensions.ripple


class GetStartedFragment : BaseFragment<FragmentGetStartedBinding>(), View.OnClickListener {

    private val getStartedVM: GetStartedViewModel by viewModels()
    private val starWars by lazy {
        StarWars.Builder()
            .setContext(requireContext())
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.innerLogoGetStarted.flashImg.logoRotate()
        binding.startUrJourneyBtn.setOnClickListener(this)
        binding.iAlreadyHaveBtn.setOnClickListener(this)
        binding.startUrJourneyBtn.ripple()
        binding.iAlreadyHaveBtn.ripple()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.startUrJourneyBtn -> {
                requireActivity().startActivity(
                    Intent(
                        requireContext(),
                        AuthActivity::class.java
                    )
                )
            }

            R.id.iAlreadyHaveBtn -> {

            }
        }
    }

    override fun vmObserver() {

    }

    override fun onDeviceBack() {
        requireActivity().finish()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetStartedBinding {
        return FragmentGetStartedBinding.inflate(inflater, container, false)
    }
}
