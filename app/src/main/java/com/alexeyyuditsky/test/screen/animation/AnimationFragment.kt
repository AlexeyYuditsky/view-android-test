package com.alexeyyuditsky.test.screen.animation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.annotation.DrawableRes
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentAnimationBinding

class AnimationFragment : AbstractFragment<FragmentAnimationBinding>(R.layout.fragment_animation) {

    override fun bind(view: View): FragmentAnimationBinding = FragmentAnimationBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            it.viewAnimation(R.anim.button_anim)
            //it.propertyAnimation(R.animator.button_animator)
            //it.frameAnimation(R.drawable.animation_list)
        }
    }

    private fun View.frameAnimation(@DrawableRes id: Int) {
        setBackgroundResource(id)
        (background as Animatable).start()
    }

    private fun View.propertyAnimation(@AnimatorRes id: Int) {
        val set = AnimatorInflater.loadAnimator(requireContext(), id) as AnimatorSet
        set.setTarget(this)
        set.start()
    }

    private fun View.viewAnimation(@AnimRes id: Int) {
        startAnimation(AnimationUtils.loadAnimation(requireContext(), id))
    }
}