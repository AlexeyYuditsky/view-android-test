package com.alexeyyuditsky.test.lifecycle.calendar

import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<Date>() {
    override fun areItemsTheSame(oldItem: Date, newItem: Date) = oldItem.value == newItem.value
    override fun areContentsTheSame(oldItem: Date, newItem: Date) = oldItem == newItem
}