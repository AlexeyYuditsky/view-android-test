package com.alexeyyuditsky.test.screen.graphql.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.databinding.FragmentGraphqlBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GraphQLFragment :
    AbstractFragment<FragmentGraphqlBinding>(R.layout.fragment_graphql) {

    override fun bind(view: View) = FragmentGraphqlBinding.bind(view)

    private val viewModel by viewModels<CountriesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryAdapter = CountryAdapter(viewModel::selectCountry)

        binding.recyclerView.adapter = countryAdapter
        binding.recyclerView.itemAnimator = null

        lifecycleScope.launch {
            viewModel.state.flowWithLifecycle(lifecycle).collect {
                if (it.selectedCountry != null) {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            CountryDialog.createCountryDialog(it.selectedCountry)
                        )
                        .commit()
                }
                countryAdapter.submitList(it.countries)
                binding.progressBar.isVisible = it.isLoading
            }
        }
    }

}