package com.alexeyyuditsky.test.screen.lifecycle.calendar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alexeyyuditsky.test.databinding.ItemDateBinding
import com.alexeyyuditsky.test.screen.lifecycle.calendar.model.Day

interface OnItemClickListener {
    fun onDateItemClick(position: Int)
}

class DateListAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<Day, DateViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val binding = ItemDateBinding.inflate(LayoutInflater.from(parent.context))
        return DateViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}