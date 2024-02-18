package com.alexeyyuditsky.test.recycler.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.databinding.ItemCarBinding
import com.alexeyyuditsky.test.databinding.ItemEmptyBinding
import com.alexeyyuditsky.test.recycler.model.CarUi

abstract class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(item: CarUi) = Unit

    class Base(
        private val binding: ItemCarBinding
    ) : CarViewHolder(binding.root) {

        override fun bind(item: CarUi) {
            val car = item as CarUi.Base
            binding.nameTextView.text = car.name
            binding.hpTextView.text = car.hp
            binding.speedTextView.text = car.speed
        }
    }

    class Empty(
        binding: ItemEmptyBinding
    ) : CarViewHolder(binding.root)
}