package com.alexeyyuditsky.test.screen.graphql.di

import com.alexeyyuditsky.test.screen.graphql.data.ApolloCountryClient
import com.alexeyyuditsky.test.screen.graphql.domain.CountryClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountryClient(countryClient: ApolloCountryClient): CountryClient

}