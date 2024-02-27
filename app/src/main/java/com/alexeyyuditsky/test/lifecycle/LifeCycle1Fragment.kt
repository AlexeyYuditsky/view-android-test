package com.alexeyyuditsky.test.lifecycle

import android.content.Context
import android.os.Bundle
import android.os.ResultReceiver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.CalendarBinding
import com.alexeyyuditsky.test.databinding.FragmentLifecycle1Binding
import com.alexeyyuditsky.test.lifecycle.bottomSheet.FirstBottomSheetDialog

class LifeCycle1Fragment : Fragment(R.layout.fragment_lifecycle_1) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        log("Fragment1LifeCycle onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("Fragment1LifeCycle onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("Fragment1LifeCycle onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("Fragment1LifeCycle onViewCreated")
        val binding = FragmentLifecycle1Binding.bind(view)

        binding.textView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    LifeCycle2Fragment().apply {
                        var str = ""
                        repeat(45000) { // крайние значения перед переполнением бандла
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

        binding.openBottomSheetButton.setOnClickListener {
            val dialog = FirstBottomSheetDialog()
            dialog.show(parentFragmentManager, null)
        }

        parentFragmentManager.setFragmentResultListener("key", viewLifecycleOwner) { _, result ->
            Toast.makeText(requireContext(), result.getString("date"), Toast.LENGTH_SHORT).show()
        }
        showCalendarDialog()
        binding.openCalendarButton.setOnClickListener {
            showCalendarDialog()
        }
    }

    private fun showCalendarDialog() {
        val binding = CalendarBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()

        binding.calendarView.selectButton { date: String ->
            parentFragmentManager.setFragmentResult("key", bundleOf("date" to date))
            dialog.dismiss()
        }
        binding.calendarView.cancelButton { dialog.dismiss() }

        dialog.show()
    }

    override fun onStart() {
        super.onStart()
        log("Fragment1LifeCycle onStart")
    }

    override fun onResume() {
        super.onResume()
        log("Fragment1LifeCycle onResume")
    }

    override fun onPause() {
        super.onPause()
        log("Fragment1LifeCycle onPause")
    }

    override fun onStop() {
        super.onStop()
        log("Fragment1LifeCycle onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("Fragment1LifeCycle onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        log("Fragment1LifeCycle onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("Fragment1LifeCycle onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        log("Fragment1LifeCycle onDetach")
    }

}