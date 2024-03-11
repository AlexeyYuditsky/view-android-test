package com.alexeyyuditsky.test.lifecycle.calendar

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.lifecycle.calendar.view.CalendarView

class CalendarDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_calendar)
            initBackground()
            setButtonListeners()
        }
    }

    private fun Dialog.initBackground() {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(window?.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams
    }

    private fun Dialog.setButtonListeners() {
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.selectButton { date ->
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(ARG_DATE to date))
            dismiss()
        }
        calendarView.cancelButton { dismiss() }
    }

    companion object {
        const val REQUEST_KEY = "calendarDialogFragment"
        const val ARG_DATE = "calendarDialogFragmentDate"
    }
}