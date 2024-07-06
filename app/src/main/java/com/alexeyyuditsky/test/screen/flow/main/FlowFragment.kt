package com.alexeyyuditsky.test.screen.flow.main

import android.os.Bundle
import android.view.View
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentChangeScreenBinding
import com.alexeyyuditsky.test.screen.flow.crypto.CryptoFragment
import com.alexeyyuditsky.test.screen.flow.user.UsersFragment

class FlowFragment :
    AbstractFragment<FragmentChangeScreenBinding>(R.layout.fragment_change_screen) {

    override fun bind(view: View) = FragmentChangeScreenBinding.bind(view)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, UsersFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.cryptoButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CryptoFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}