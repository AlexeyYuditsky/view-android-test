package com.alexeyyuditsky.test.lifecycle.calendar.adapter

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.TextViewCompat
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemSpinnerBinding
import com.alexeyyuditsky.test.lifecycle.calendar.model.Month

class SpinnerAdapter(
    context: Context,
    resource: Int
) : ArrayAdapter<Month>(context, resource) {

    fun updateMonthList(newMonthList: List<Month>) {
        if (count != 0) clear()
        addAll(newMonthList)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemSpinnerBinding.bind(
            convertView ?: ItemSpinnerBinding.inflate(LayoutInflater.from(context)).root
        )

        val month = getItem(position) ?: return binding.root
        return binding.root.apply {
            text = month.name
            typeface = ResourcesCompat.getFont(parent.context, R.font.formular_medium)
            setPadding(20, 0, 0, 0)
            gravity = Gravity.CENTER_HORIZONTAL

            TextViewCompat.setAutoSizeTextTypeWithDefaults(
                this,
                TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE
            )
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                this,
                6,
                16,
                1,
                TypedValue.COMPLEX_UNIT_SP
            )
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemSpinnerBinding.bind(
            convertView ?: ItemSpinnerBinding.inflate(
                LayoutInflater.from(context), parent, false
            ).root
        )

        val month = getItem(position) ?: return binding.root
        return binding.root.apply {

            text = month.name

            setPadding(
                (16 * context.resources.displayMetrics.density + 0.5f).toInt(),
                0,
                0,
                0
            )

            if (month.isSelected) {
                setBackgroundResource(R.color.orange)
                setTextColor(Color.WHITE)
            } else {
                setBackgroundResource(R.color.white)
                setTextColor(Color.BLACK)
            }
        }
    }
}