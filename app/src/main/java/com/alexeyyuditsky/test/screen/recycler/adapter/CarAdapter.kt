package com.alexeyyuditsky.test.screen.recycler.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemCarBinding
import com.alexeyyuditsky.test.databinding.ItemEmptyBinding
import com.alexeyyuditsky.test.screen.recycler.model.CarUi

class CarAdapter : RecyclerView.Adapter<CarViewHolder>() {

    private val carList = mutableListOf<CarUi>()

    override fun getItemViewType(position: Int): Int = when (carList[position]) {
        is CarUi.Base -> R.layout.item_car
        is CarUi.Empty -> R.layout.item_empty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder =
        when (viewType) {
            R.layout.item_car -> {
                val binding =
                    ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CarViewHolder.Base(binding)
            }

            R.layout.item_empty -> {
                val binding =
                    ItemEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CarViewHolder.Empty(binding)
            }

            else -> throw IllegalArgumentException("unknown viewType")
        }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) =
        holder.bind(carList[position])

    override fun getItemCount(): Int = carList.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newCarList: List<CarUi>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }

    fun removeSecondItem() {
        carList.removeAt(1)
        notifyItemRemoved(1)
    }
}

