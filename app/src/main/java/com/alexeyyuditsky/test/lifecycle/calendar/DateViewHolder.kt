package com.alexeyyuditsky.test.lifecycle.calendar

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemDateBinding

class DateViewHolder(
    private val binding: ItemDateBinding,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener { listener.onItemClick(layoutPosition) }
    }

    fun bind(date: Date) {
        binding.dateTextView.text = date.value
        when {
            date.isSelected -> setViewSettings(R.drawable.round_orange, R.color.white)
            date.isAdditional -> setViewSettings(R.drawable.rectangle_white, R.color.light_grey)
            else -> setViewSettings(R.drawable.rectangle_white, R.color.black)
        }
    }

    private fun setViewSettings(@DrawableRes background: Int, @ColorRes color: Int) =
        with(binding.dateTextView) {
            setBackgroundResource(background)
            setTextColor(ContextCompat.getColor(context, color))
        }
}