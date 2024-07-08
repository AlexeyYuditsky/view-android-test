package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemCryptoBinding

class CryptoViewHolder(
    private val binding: ItemCryptoBinding
) : ViewHolder(binding.root) {

    fun bind(currency: Currency) = with(binding) {
        name.text = currency.name
        price.text = itemView.context.getString(R.string.currencyPrice, currency.price)
    }

}