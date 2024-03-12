package com.alexeyyuditsky.test.customView

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentCustomViewBinding

class CustomViewFragment :
    AbstractFragment<FragmentCustomViewBinding>(R.layout.fragment_custom_view) {

    override fun bind(view: View): FragmentCustomViewBinding = FragmentCustomViewBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}