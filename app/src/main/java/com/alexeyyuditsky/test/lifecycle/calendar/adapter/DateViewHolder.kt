package com.alexeyyuditsky.test.lifecycle.calendar.adapter

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemDateBinding
import com.alexeyyuditsky.test.lifecycle.calendar.model.Day

class DateViewHolder(
    private val binding: ItemDateBinding,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener { listener.onDateItemClick(layoutPosition) }
    }

    fun bind(day: Day) {
        binding.dateTextView.text = day.name
        when {
            day.isSelected -> setViewSettings(R.drawable.round_orange, R.color.white)
            day.isAdditional -> setViewSettings(R.drawable.round_white, R.color.light_grey)
            else -> setViewSettings(R.drawable.round_white, R.color.black)
        }
    }

    private fun setViewSettings(@DrawableRes background: Int, @ColorRes color: Int) =
        with(binding.dateTextView) {
            setBackgroundResource(background)
            setTextColor(ContextCompat.getColor(context, color))
        }
}
