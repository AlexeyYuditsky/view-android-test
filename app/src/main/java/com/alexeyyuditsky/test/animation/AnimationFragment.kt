package com.alexeyyuditsky.test.animation

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentAnimationBinding

class AnimationFragment : AbstractFragment<FragmentAnimationBinding>(R.layout.fragment_animation) {

    override fun bind(view: View): FragmentAnimationBinding = FragmentAnimationBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

        }
    }
}