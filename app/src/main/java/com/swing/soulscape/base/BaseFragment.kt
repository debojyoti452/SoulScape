package com.swing.soulscape.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import timber.log.Timber

abstract class BaseFragment<T : ViewBinding> : Fragment(), BaseInterface {

    private var _binding: T? = null

    private val binding get() = _binding

    abstract fun vmObserver()

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup?) : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateView(inflater, container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showLog(msg: Any) {
        Timber.d(msg.toString())
    }
}
