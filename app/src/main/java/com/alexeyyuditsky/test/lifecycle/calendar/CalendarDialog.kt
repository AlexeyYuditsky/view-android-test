package com.alexeyyuditsky.test.lifecycle.calendar

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.CalendarBinding

class CalendarDialog : DialogFragment() {

    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = CalendarBinding.inflate(layoutInflater)
        binding.calendarView.setListener {

        }
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }*/
}