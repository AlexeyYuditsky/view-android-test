package com.alexeyyuditsky.test.screen.graphql.data

import com.alexeyyuditsky.CountriesQuery
import com.alexeyyuditsky.CountryQuery
import com.alexeyyuditsky.test.screen.graphql.domain.DetailedCountry
import com.alexeyyuditsky.test.screen.graphql.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        emoji = emoji,
        languages = languages.map { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        capital = capital ?: "No capital",
        emoji = emoji,
    )
}