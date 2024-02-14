package com.alexeyyuditsky.promocodes.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alexeyyuditsky.promocodes.R
import com.alexeyyuditsky.promocodes.databinding.FragmentPromocodesBinding
import com.google.android.material.snackbar.Snackbar

class PromocodesFragment : Fragment(R.layout.fragment_promocodes) {

    private var _binding: FragmentPromocodesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<PromocodesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPromocodesBinding.bind(view)
        binding.shareButton.setOnClickListener { onShareButtonPressed() }
        viewModel.state.observe(viewLifecycleOwner, ::observeNavigateState)
    }

    private fun onShareButtonPressed() = viewModel.fetchPromocodes()

    private fun observeNavigateState(state: State) =
        when (state) {
            is State.Loading -> {
                // todo loading
            }

            is State.Error -> Snackbar.make(binding.root, state.text, Snackbar.LENGTH_SHORT).show()
            is State.Next -> createIntent(state.promocode)
        }

    private fun createIntent(promocode: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, promocode)
            type = "text/plain"
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

