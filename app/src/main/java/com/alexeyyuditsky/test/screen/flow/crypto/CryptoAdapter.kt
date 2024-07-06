package com.alexeyyuditsky.test.screen.flow.crypto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alexeyyuditsky.test.databinding.ItemCryptoBinding

class CryptoAdapter : ListAdapter<Currency, CryptoViewHolder>(CryptoDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}