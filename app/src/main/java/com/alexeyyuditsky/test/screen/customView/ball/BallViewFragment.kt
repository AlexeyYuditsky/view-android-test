package com.alexeyyuditsky.test.screen.customView.ball

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentBallBinding

class BallViewFragment : AbstractFragment<FragmentBallBinding>(R.layout.fragment_ball) {

    override fun bind(view: View) = FragmentBallBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}