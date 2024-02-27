package com.alexeyyuditsky.test.lifecycle.calendar

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.GridLayoutManager
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.CustomCalendarBinding

interface OnItemSelectedSpinnerListener : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
}

enum class CalendarButtonAction {
    POSITIVE, NEGATIVE
}

typealias OnCalendarSelectButtonListener = (date: String) -> Unit
typealias OnCalendarCancelButtonListener = () -> Unit

class CalendarView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attr, defStyleAttr, defStyleRes), OnItemClickListener,
    OnItemSelectedSpinnerListener {

    private val binding = CustomCalendarBinding.inflate(LayoutInflater.from(context), this)
    private val dayAdapter = DateListAdapter(this)
    private val monthAdapter = SpinnerAdapter(context, R.layout.item_spinner)
    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        val viewModelStoreOwner = findViewModelStoreOwner(context)
        ViewModelProvider(viewModelStoreOwner)[CalendarViewModel::class.java]
    }
    private var selectListener: OnCalendarSelectButtonListener? = null
    private var cancelListener: OnCalendarCancelButtonListener? = null

    var launch = 1

    init {
        setBackgroundResource(R.drawable.spinner_popup_background)
        initSpinner()
        initRecycler()
        initListeners()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.dateLiveData.observeForever { dateList -> dayAdapter.submitList(dateList) }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (launch++ == 1) return
        monthAdapter.selectedPosition = position
        viewModel.getDateList(position, binding.yearTextView.text.toString().toInt())
    }

    override fun onItemClick(position: Int) = dayAdapter.updateList(position)

    fun selectButton(listener: OnCalendarSelectButtonListener?) {
        selectListener = listener
    }

    fun cancelButton(listener: OnCalendarCancelButtonListener?) {
        cancelListener = listener
    }

    private fun initListeners() {
        binding.cancelButton.setOnClickListener { cancelListener?.invoke() }
        binding.selectButton.setOnClickListener {
            val date = buildString {
                append(dayAdapter.selectedDate)
                append(".")
                append(monthAdapter.selectedMonth)
                append(".")
                append(binding.yearTextView.text.takeLast(2))
            }
            selectListener?.invoke(date)
        }
    }

    private fun pinDropDownToLeftEdge() {
        val constraintLayoutLocation = IntArray(2)
        binding.root.getLocationOnScreen(constraintLayoutLocation)
        val spinnerLocation = IntArray(2)
        binding.spinner.getLocationOnScreen(spinnerLocation)
        val offsetDistanceToLeftEdge = constraintLayoutLocation.first() - spinnerLocation.first()
        binding.spinner.dropDownHorizontalOffset = offsetDistanceToLeftEdge
    }

    private fun findViewModelStoreOwner(context: Context): ViewModelStoreOwner {
        var currentContext = context
        while (currentContext !is ViewModelStoreOwner && currentContext is ContextWrapper) {
            currentContext = currentContext.baseContext
        }
        return currentContext as ViewModelStoreOwner
    }

    private fun initRecycler() = with(binding) {
        recyclerView.adapter = dayAdapter
        recyclerView.layoutManager = GridLayoutManager(context, SPAN_COUNT)
    }

    private fun initSpinner() = with(binding) {
        spinner.adapter = monthAdapter
        spinner.setSelection(viewModel.getCurrentMonth())
        spinner.onItemSelectedListener = this@CalendarView
        spinner.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN)
                if (launch++ == 2)
                    pinDropDownToLeftEdge()
            false
        }
    }

    private companion object {
        const val SPAN_COUNT = 7
    }
}