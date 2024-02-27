package com.alexeyyuditsky.test.lifecycle.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.core.log
import com.alexeyyuditsky.test.databinding.ItemDateBinding

interface OnItemClickListener {
    fun onItemClick(position: Int)
}

class DateListAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<Date, DateViewHolder>(DiffCallback()) {

    private var selectedPosition = RecyclerView.NO_POSITION
    var selectedDate = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val binding = ItemDateBinding.inflate(LayoutInflater.from(parent.context))
        return DateViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun submitList(list: List<Date>?) {
        selectedPosition = list!!.indexOfFirst { it.isSelected }
        super.submitList(list)
    }

    fun updateList(position: Int) {
        val date = currentList[position]
        if (position == selectedPosition || date.isAdditional || date.value.toIntOrNull() == null) return

        val newList = currentList.mapIndexed { index, date ->
            when (index) {
                position -> {
                    selectedDate = date.value
                    date.copy(isSelected = true)
                }

                selectedPosition -> date.copy(isSelected = false)
                else -> date
            }
        }

        selectedPosition = position

        submitList(newList)
    }
}

