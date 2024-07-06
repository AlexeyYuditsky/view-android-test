package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexeyyuditsky.test.databinding.ItemCryptoBinding

class CryptoViewHolder(
    private val binding: ItemCryptoBinding
) : ViewHolder(binding.root) {

    fun bind(currency: Currency) = with(binding) {
        name.text = currency.name
        value.text = currency.value
    }

}