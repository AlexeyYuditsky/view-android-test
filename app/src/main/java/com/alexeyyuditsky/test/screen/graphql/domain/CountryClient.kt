package com.alexeyyuditsky.test.screen.graphql.domain

interface CountryClient {
    suspend fun fetchCountries(): List<SimpleCountry>
    suspend fun fetchCountry(code: String): DetailedCountry?
}