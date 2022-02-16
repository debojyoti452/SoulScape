package com.swing.soulscape.features.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.swing.soulscape.R
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentSignupBinding
import com.swing.soulscape.features.auth.viewmodel.SignUpViewModel
import com.swing.soulscape.utils.Extensions.ripple

class SignUpFragment : BaseFragment<FragmentSignupBinding>(), View.OnClickListener {

    private val signupVM: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.signBackBtn.ripple()
        binding.signBackBtn.setOnClickListener(this)
        binding.welcomeTagTV.setHtml(getString(R.string.welcome_to_soulscape))
    }

    override fun vmObserver() {

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.signBackBtn -> {

            }
        }
    }

    override fun onDeviceBack() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignupBinding {
        return FragmentSignupBinding.inflate(inflater, container, false)
    }
}
