package com.alexeyyuditsky.test.screen.graphql.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractDialog
import com.alexeyyuditsky.test.databinding.DialogCountryBinding
import com.alexeyyuditsky.test.screen.graphql.domain.DetailedCountry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDialog : AbstractDialog<DialogCountryBinding>(R.layout.dialog_country) {

    override fun bind(view: View) = DialogCountryBinding.bind(view)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country =
            requireArguments().getParcelable(KEY_DETAILED_COUNTRY, DetailedCountry::class.java)

        binding.flagTextView.text = country?.emoji
        binding.countryTextView.text = country?.name
        binding.capitalTextView.text = country?.capital
        binding.continentTextView.text = country?.continent
        binding.currencyTextView.text = country?.currency
        binding.languageTextView.text = country?.languages?.joinToString()
    }

    companion object {
        private const val KEY_DETAILED_COUNTRY = "key_detailed_country"

        fun createCountryDialog(detailedCountry: DetailedCountry) = CountryDialog().apply {
            arguments = bundleOf(KEY_DETAILED_COUNTRY to detailedCountry)
        }
    }

}