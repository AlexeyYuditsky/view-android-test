package com.alexeyyuditsky.test.screen.graphql.domain

import javax.inject.Inject

interface FetchCountryUseCase {

    suspend operator fun invoke(code: String): DetailedCountry?

    class Base @Inject constructor(
        private val countryClient: CountryClient
    ) : FetchCountryUseCase {
        override suspend fun invoke(code: String): DetailedCountry? {
            return countryClient.fetchCountry(code)
        }
    }

}