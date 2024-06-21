package com.alexeyyuditsky.test.screen.flow

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentFlowBinding

class FlowFragment : AbstractFragment<FragmentFlowBinding>(R.layout.fragment_flow) {

    private val viewModel by lazy {
        ViewModelProvider(this)[FlowViewModel::class.java]
    }

    override fun bind(view: View) = FragmentFlowBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addUserButton.setOnClickListener {
            viewModel.addUser(binding.namesEditText.text.toString())
        }

        viewModel.user.observe(viewLifecycleOwner) {
            binding.namesTextView.text = it.joinToString()
        }
    }

}