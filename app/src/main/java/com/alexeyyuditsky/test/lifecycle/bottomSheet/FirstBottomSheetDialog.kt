package com.alexeyyuditsky.test.lifecycle.bottomSheet

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import android.view.View
import androidx.core.os.bundleOf
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.DialogBottomSheet1Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FirstBottomSheetDialog : BottomSheetDialogFragment(R.layout.dialog_bottom_sheet_1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = DialogBottomSheet1Binding.bind(view)

        binding.textView2.setOnClickListener {

            parentFragmentManager.setFragmentResultListener(
                "1",
                viewLifecycleOwner
            ) { code, bundle ->
                if (code == "1") {
                    val list = bundle.getStringArrayList("list")
                    binding.textView5.text = list?.first()
                    binding.textView6.text = list?.get(1)
                }
            }

            val dialog = SecondBottomSheetDialog()
            dialog.show(parentFragmentManager, null)
        }
    }
}