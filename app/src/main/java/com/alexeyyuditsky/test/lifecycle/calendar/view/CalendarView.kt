package com.alexeyyuditsky.test.lifecycle.calendar.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemCalendarBinding
import com.alexeyyuditsky.test.lifecycle.calendar.adapter.DateListAdapter
import com.alexeyyuditsky.test.lifecycle.calendar.adapter.OnItemClickListener
import com.alexeyyuditsky.test.lifecycle.calendar.adapter.SpinnerAdapter

typealias OnCalendarSelectButtonListener = (date: String) -> Unit
typealias OnCalendarCancelButtonListener = () -> Unit

class CalendarView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attr, defStyleAttr, defStyleRes), OnItemClickListener {

    private val binding = ItemCalendarBinding.inflate(LayoutInflater.from(context), this)

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(findViewTreeViewModelStoreOwner()!!).get<CalendarViewModel>()
    }

    private val daysAdapter = DateListAdapter(this)
    private val monthsAdapter = SpinnerAdapter(context, R.layout.item_spinner)

    private var selectListener: OnCalendarSelectButtonListener? = null
    private var cancelListener: OnCalendarCancelButtonListener? = null

    private var isPinDropDownToLeftEdge = false

    init {
        initSpinner()
        initRecycler()
        initListeners()
    }

    override fun onDateItemClick(position: Int) {
        viewModel.updateDayListByPosition(position)
        viewModel.changeButtonState(true)
    }

    override fun onAttachedToWindow() = with(viewModel) {
        super.onAttachedToWindow()
        monthListLiveData.observe(findViewTreeLifecycleOwner()!!) { monthList ->
            monthsAdapter.updateMonthList(monthList)
            binding.spinner.setSelection(monthList.indexOfFirst { it.isSelected })
        }
        yearLiveData.observe(findViewTreeLifecycleOwner()!!) { year ->
            binding.yearTextView.text = year.toString()
        }
        dayListLiveData.observe(findViewTreeLifecycleOwner()!!) { dayList ->
            daysAdapter.submitList(dayList)
        }
        selectButtonDateLiveData.observe(findViewTreeLifecycleOwner()!!) { date ->
            selectListener?.invoke(date)
        }
        selectButtonStateLiveData.observe(findViewTreeLifecycleOwner()!!) { isActiveState ->
            setButtonStyle(isActiveState)
        }
    }

    fun selectButton(listener: OnCalendarSelectButtonListener?) {
        selectListener = listener
    }

    fun cancelButton(listener: OnCalendarCancelButtonListener?) {
        cancelListener = listener
    }

    private fun setButtonStyle(isActiveState: Boolean) = with(binding.selectButton) {
        if (isActiveState) {
            isEnabled = true
            setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
            setTextColor(Color.WHITE)
        } else {
            isEnabled = false
            setBackgroundColor(ContextCompat.getColor(context, R.color.light_grey))
            setTextColor(Color.BLACK)
        }
    }

    private fun initListeners() = with(binding) {
        arrowPrevMonthImageView.setOnClickListener { viewModel.backMonth() }
        arrowNextMonthImageView.setOnClickListener { viewModel.nextMonth() }
        arrowPrevYearImageView.setOnClickListener { viewModel.backYear() }
        arrowNextYearImageView.setOnClickListener { viewModel.nextYear() }

        cancelButton.setOnClickListener { cancelListener?.invoke() }
        selectButton.setOnClickListener { viewModel.sendDate() }
    }

    private fun pinDropDownToLeftEdge() = with(binding) {
        val constraintLayoutLocation = IntArray(2)
        root.getLocationOnScreen(constraintLayoutLocation)
        val spinnerLocation = IntArray(2)
        spinner.getLocationOnScreen(spinnerLocation)
        val offsetDistanceToLeftEdge = constraintLayoutLocation.first() - spinnerLocation.first()
        spinner.dropDownHorizontalOffset = offsetDistanceToLeftEdge
    }

    private fun initRecycler() = with(binding.recyclerView) {
        adapter = daysAdapter
        layoutManager = GridLayoutManager(context, SPAN_COUNT)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initSpinner() = with(binding.spinner) {
        adapter = monthsAdapter
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.updateMonthList(position)
                viewModel.updateDayList()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (!isPinDropDownToLeftEdge) {
                    pinDropDownToLeftEdge()
                    isPinDropDownToLeftEdge = true
                }
            }
            false
        }
    }

    private companion object {
        const val SPAN_COUNT = 7
    }
}