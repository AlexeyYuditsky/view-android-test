package com.alexeyyuditsky.test.screen.lifecycle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.FragmentLifecycle2Binding

class LifeCycle2Fragment : AbstractFragment<FragmentLifecycle2Binding>(R.layout.fragment_lifecycle_2) {

    private val viewModel by viewModels<LifeCycleFragment2ViewModel>()

    override fun bind(view:View): FragmentLifecycle2Binding = FragmentLifecycle2Binding.bind(view)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        log("Fragment2LifeCycle onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("Fragment2LifeCycle onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("Fragment2LifeCycle onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("Fragment2LifeCycle onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        log("LifeCycleFragment2HashCode: ${viewModel.hashCode()}")
        log("Fragment2LifeCycle onStart")
    }

    override fun onResume() {
        super.onResume()
        log("Fragment2LifeCycle onResume")
    }

    override fun onPause() {
        super.onPause()
        log("Fragment2LifeCycle onPause")
    }

    override fun onStop() {
        super.onStop()
        log("Fragment2LifeCycle onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        log("Fragment2LifeCycle onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("Fragment2LifeCycle onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        log("Fragment2LifeCycle onDetach")
    }
}