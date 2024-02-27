package com.alexeyyuditsky.test.lifecycle.calendar

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

class SpinnerAdapter(context: Context, resource: Int) :
    ArrayAdapter<String>(context, resource, context.resources.getStringArray(R.array.months)) {

    var selectedPosition = NO_SELECTION
    var selectedMonth = ""

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemSpinnerBinding.bind(
            convertView ?: ItemSpinnerBinding.inflate(
                LayoutInflater.from(context)
            ).root
        )

        binding.textView.text = getItem(position)
        binding.textView.typeface = ResourcesCompat.getFont(parent.context, R.font.formular_medium)
        binding.textView.setPadding(20, 0, 0, 0)
        binding.textView.gravity = Gravity.CENTER_HORIZONTAL

        TextViewCompat.setAutoSizeTextTypeWithDefaults(
            binding.textView,
            TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE
        )
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
            binding.textView,
            6,
            16,
            1,
            TypedValue.COMPLEX_UNIT_SP
        )

        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemSpinnerBinding.bind(
            convertView ?: ItemSpinnerBinding.inflate(
                LayoutInflater.from(context), parent, false
            ).root
        )

        binding.textView.text = getItem(position)

        val startPixels = getPixelFromDp(parent.context, 16)
        binding.textView.setPadding(startPixels, 0, 0, 0)

        if (position == selectedPosition) {
            binding.textView.setBackgroundResource(R.color.orange)
            binding.textView.setTextColor(Color.WHITE)
            selectedMonth = binding.textView.text.toString()
        }

        return binding.root
    }

    private fun getPixelFromDp(context: Context, dp: Int): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}