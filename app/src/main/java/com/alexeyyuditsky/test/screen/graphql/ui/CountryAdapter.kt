package com.alexeyyuditsky.test.screen.graphql.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexeyyuditsky.test.databinding.ItemCountryBinding
import com.alexeyyuditsky.test.screen.graphql.domain.SimpleCountry

class CountryAdapter(
    private val countryClickListener: (code: String) -> Unit
) : ListAdapter<SimpleCountry, CountryViewHolder>(CountryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemCountry =
            ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(itemCountry, countryClickListener)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class CountryViewHolder(
    private val binding: ItemCountryBinding,
    private val countryClickListener: (code: String) -> Unit
) : ViewHolder(binding.root) {

    fun bind(item: SimpleCountry) = with(binding) {
        flagTextView.text = item.emoji
        cityTextView.text = item.capital
        countryTextView.text = item.name
        itemView.setOnClickListener { countryClickListener.invoke(item.code) }
    }
}

class CountryDiffCallback : DiffUtil.ItemCallback<SimpleCountry>() {

    override fun areItemsTheSame(oldItem: SimpleCountry, newItem: SimpleCountry): Boolean =
        oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: SimpleCountry, newItem: SimpleCountry): Boolean =
        oldItem == newItem
}