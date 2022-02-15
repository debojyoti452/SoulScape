package com.swing.soulscape.features.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentSignupBinding
import com.swing.soulscape.features.auth.viewmodel.SignUpViewModel

class SignUpFragment : BaseFragment<FragmentSignupBinding>() {

    private val signupVM: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun vmObserver() {

    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignupBinding {
        return FragmentSignupBinding.inflate(inflater, container, false)
    }
}
