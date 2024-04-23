package com.alexeyyuditsky.test.customView.pyramid

import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentPyramidBinding

class PyramidViewFragment : AbstractFragment<FragmentPyramidBinding>(R.layout.fragment_pyramid) {

    override fun bind(view: View) = FragmentPyramidBinding.bind(view)

}