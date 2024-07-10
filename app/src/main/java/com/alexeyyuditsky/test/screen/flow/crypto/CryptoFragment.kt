package com.alexeyyuditsky.test.screen.flow.crypto

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentCryptoBinding
import kotlinx.coroutines.launch

class CryptoFragment : AbstractFragment<FragmentCryptoBinding>(R.layout.fragment_crypto) {

    private val viewModel by viewModels<CryptoViewModel>()
    private val adapter = CryptoAdapter()

    override fun bind(view: View) = FragmentCryptoBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() = lifecycleScope.launch {
        viewModel.state
            .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
            .collect {
                when (it) {
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