package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.recyclerview.widget.DiffUtil

class CryptoDiffUtilCallback : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }
}