package com.alexeyyuditsky.test.screen.lifecycle.calendar.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alexeyyuditsky.test.screen.lifecycle.calendar.model.Day

class DiffCallback : DiffUtil.ItemCallback<Day>() {
    override fun areItemsTheSame(oldItem: Day, newItem: Day) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: Day, newItem: Day) = oldItem == newItem
}
