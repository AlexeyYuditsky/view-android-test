package com.alexeyyuditsky.test.screen.graphql.data

import com.alexeyyuditsky.CountriesQuery
import com.alexeyyuditsky.CountryQuery
import com.alexeyyuditsky.test.screen.graphql.domain.CountryClient
import com.alexeyyuditsky.test.screen.graphql.domain.DetailedCountry
import com.alexeyyuditsky.test.screen.graphql.domain.SimpleCountry
import com.apollographql.apollo.ApolloClient
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun fetchCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun fetchCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}

