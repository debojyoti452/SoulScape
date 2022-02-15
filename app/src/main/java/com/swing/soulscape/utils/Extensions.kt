package com.swing.soulscape.utils

import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView


object Extensions {
    fun AppCompatImageView.logoRotate() {
        val rotateAnimation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.interpolator = LinearInterpolator()
        rotateAnimation.duration = 1800L
        rotateAnimation.repeatCount = Animation.INFINITE
        this.startAnimation(rotateAnimation)
    }
}
