package com.swing.soulscape.features.flash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.swing.soulscape.R
import com.swing.soulscape.base.BaseActivity
import com.swing.soulscape.databinding.ActivityFlashBinding
import com.swing.soulscape.features.flash.view_model.FlashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FlashActivity : BaseActivity() {

    private lateinit var binding: ActivityFlashBinding
    private val flashViewModel: FlashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initialize() {
        lifecycleScope.launch {
            delay(1000L)
            flashViewModel.flashScreenChange()
        }
    }

    override fun vmObserver() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navFlashHost) as NavHostFragment
        val navController = navHostFragment.navController

        flashViewModel.splashScreenTrans.observe(this@FlashActivity) {
            if (it == true) {
                navController
                    .navigate(R.id.action_splashFragment_to_getStartedFragment)
            }
        }
    }

}
