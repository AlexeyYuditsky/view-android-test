package com.alexeyyuditsky.test.lifecycle.calendar.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alexeyyuditsky.test.lifecycle.calendar.model.Day

class DiffCallback : DiffUtil.ItemCallback<Day>() {
    override fun areItemsTheSame(oldItem: Day, newItem: Day) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: Day, newItem: Day) = oldItem == newItem
}
