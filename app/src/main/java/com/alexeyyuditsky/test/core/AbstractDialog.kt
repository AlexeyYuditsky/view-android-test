package com.alexeyyuditsky.test.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class AbstractDialog<T : ViewBinding>(
    @LayoutRes idLayout: Int
) : BottomSheetDialogFragment(idLayout) {

    private var _binding: T? = null
    val binding: T get() = _binding!!

    protected abstract fun bind(view: View): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}