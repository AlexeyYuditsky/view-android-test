package com.alexeyyuditsky.test.screen.graphql.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.DialogCountryBinding
import com.alexeyyuditsky.test.databinding.FragmentGraphqlBinding
import com.alexeyyuditsky.test.screen.graphql.ui.data.CountriesState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GraphQLFragment :
    AbstractFragment<FragmentGraphqlBinding>(R.layout.fragment_graphql) {

    override fun bind(view: View) = FragmentGraphqlBinding.bind(view)

    private val viewModel by viewModels<CountriesViewModel>()

    private lateinit var countryAdapter: CountryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryAdapter = CountryAdapter(viewModel::selectCountry)
        binding.recyclerView.adapter = countryAdapter
        binding.recyclerView.itemAnimator = null

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect(::observeCountriesState)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun observeCountriesState(countriesState: CountriesState) {
        if (countriesState.selectedCountry != null) {
            val binding = DialogCountryBinding.inflate(LayoutInflater.from(context))
            val dialog = AlertDialog.Builder(requireContext())
                .setView(binding.root)
                .create()

            with(binding) {
                flagTextView.text = countriesState.selectedCountry.emoji
                countryTextView.text = countriesState.selectedCountry.name
                continentTextView.text = "Continent: " + countriesState.selectedCountry.continent
                capitalTextView.text = "Capital: " + countriesState.selectedCountry.capital
                currencyTextView.text = "Currency: " + countriesState.selectedCountry.currency
                languageTextView.text =
                    "Language: " + countriesState.selectedCountry.languages.joinToString()
            }

            dialog.show()
        } else {
            countryAdapter.submitList(countriesState.countries)
            binding.progressBar.isVisible = countriesState.isLoading
        }
    }

}