package com.alexeyyuditsky.test.screen.graphql.ui.data

import com.alexeyyuditsky.test.screen.graphql.domain.DetailedCountry
import com.alexeyyuditsky.test.screen.graphql.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)