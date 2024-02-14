package com.alexeyyuditsky.test

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.alexeyyuditsky.test.core.log

@SuppressLint("ResourceType")
abstract class AbstractFragment(@IdRes idLayout: Int) : Fragment(idLayout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("ABSTRACT fragment2 onViewCreated")
    }
}

@SuppressLint("ResourceType")
class Fragment2 : AbstractFragment(R.layout.fragment_2) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        log("fragment2 onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("fragment2 onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("fragment2 onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("fragment2 onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        log("fragment2 onStart")
    }

    override fun onResume() {
        super.onResume()
        log("fragment2 onResume")
    }

    override fun onPause() {
        super.onPause()
        log("fragment2 onPause")
    }

    override fun onStop() {
        super.onStop()
        log("fragment2 onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        log("fragment2 onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("fragment2 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        log("fragment2 onDetach")
    }
}