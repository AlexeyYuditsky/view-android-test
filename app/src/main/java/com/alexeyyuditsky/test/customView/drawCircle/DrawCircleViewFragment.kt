package com.alexeyyuditsky.test.customView.drawCircle

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentDrawCircleBinding

class DrawCircleViewFragment : AbstractFragment<FragmentDrawCircleBinding>(R.layout.fragment_draw_circle) {

    override fun bind(view: View) = FragmentDrawCircleBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding // bla bla bla
    }

}