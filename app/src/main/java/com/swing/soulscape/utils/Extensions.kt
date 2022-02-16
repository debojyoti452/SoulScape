package com.swing.soulscape.utils

import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat


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

    fun View.ripple(): View {
        val value = TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, value, true)
        foreground = ContextCompat.getDrawable(context, value.resourceId)
        isFocusable = true // Required for some view types
        return this
    }
}
