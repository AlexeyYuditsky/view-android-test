package com.alexeyyuditsky.test.customView.circleDiagram

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentCircleDiagramBinding

class CirceDiagramFragment :
    AbstractFragment<FragmentCircleDiagramBinding>(R.layout.fragment_circle_diagram) {

    override fun bind(view: View) = FragmentCircleDiagramBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}