package com.alexeyyuditsky.test.screen.flow.crypto

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentCryptoBinding

class CryptoFragment : AbstractFragment<FragmentCryptoBinding>(R.layout.fragment_crypto) {

    override fun bind(view: View) = FragmentCryptoBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CryptoAdapter()
        adapter.submitList(listOf(Currency("BTC", "$12333"), Currency("USDT", "$33356")))
        binding.recyclerView.adapter = adapter
    }
}