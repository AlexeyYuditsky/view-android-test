package com.alexeyyuditsky.test

import android.content.Context
import android.os.Bundle
import android.os.ResultReceiver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.Fragment1Binding

class Fragment1 : Fragment(R.layout.fragment_1) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        log("fragment1 onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("fragment1 onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("fragment1 onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("fragment1 onViewCreated")
        val binding = Fragment1Binding.bind(view)

        binding.textView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    Fragment2().apply {
                        var str = ""
                        repeat(45000) {
                            str += "hello "
                        }
                        arguments = bundleOf("str" to str)
                    }
                )
                .addToBackStack(null)
                .commit()
        }

        binding.sendButton.setOnClickListener {
            val callback = requireActivity().intent.getParcelableExtra<ResultReceiver>("receiver")
                ?: return@setOnClickListener
            callback.send(1, bundleOf("sample" to "Hello"))
        }
    }

    override fun onStart() {
        super.onStart()
        log("fragment1 onStart")
    }

    override fun onResume() {
        super.onResume()
        log("fragment1 onResume")
    }

    override fun onPause() {
        super.onPause()
        log("fragment1 onPause")
    }

    override fun onStop() {
        super.onStop()
        log("fragment1 onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        log("fragment1 onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("fragment1 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        log("fragment1 onDetach")
    }

}