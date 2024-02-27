package com.alexeyyuditsky.test.lifecycle.bottomSheet

import android.os.Bundle
import android.os.ResultReceiver
import android.view.View
import androidx.core.os.bundleOf
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.DialogBottomSheet2Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SecondBottomSheetDialog : BottomSheetDialogFragment(R.layout.dialog_bottom_sheet_2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = DialogBottomSheet2Binding.bind(view)

        binding.textView5.setOnClickListener {
            parentFragmentManager.setFragmentResult(
                "1",
                bundleOf("list" to arrayListOf(binding.textView5.text, binding.textView6.text))
            )
            dismiss()
        }
    }

}