package com.alexeyyuditsky.test.screen.graphql.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.core.log
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
        lifecycleScope.launch {
            log(viewModel.state.value)
        }
    }

}