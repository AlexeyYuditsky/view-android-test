package com.alexeyyuditsky.test.screen.graphql.domain

import javax.inject.Inject

interface FetchCountriesUseCase {

    suspend operator fun invoke(): List<SimpleCountry>

    class Base @Inject constructor(
        private val countryClient: CountryClient
    ) : FetchCountriesUseCase {
        override suspend fun invoke(): List<SimpleCountry> {
            return countryClient
                .fetchCountries()
                .sortedBy { it.name }
        }
    }

}