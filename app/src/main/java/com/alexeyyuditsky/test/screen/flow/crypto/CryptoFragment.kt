package com.alexeyyuditsky.test.screen.flow.crypto

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentCryptoBinding

class CryptoFragment : AbstractFragment<FragmentCryptoBinding>(R.layout.fragment_crypto) {

    private val viewModel by viewModels<CryptoViewModel>()
    private val adapter = CryptoAdapter()

    override fun bind(view: View) = FragmentCryptoBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is State.Initial -> {}

                is State.Loading -> {
                    binding.progress.isVisible = true
                }

                is State.Content -> {
                    binding.progress.isVisible = false
                    adapter.submitList(it.currencyList)
                }
            }
        }
    }
}