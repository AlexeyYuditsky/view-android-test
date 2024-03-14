package com.alexeyyuditsky.test.customView

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentBallCustomViewBinding

class CustomViewFragment :
    AbstractFragment<FragmentBallCustomViewBinding>(R.layout.fragment_ball_custom_view) {

    override fun bind(view: View) = FragmentBallCustomViewBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}