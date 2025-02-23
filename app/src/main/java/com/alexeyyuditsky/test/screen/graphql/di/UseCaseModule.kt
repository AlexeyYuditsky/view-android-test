package com.alexeyyuditsky.test.screen.graphql.di

import com.alexeyyuditsky.test.screen.graphql.domain.FetchCountriesUseCase
import com.alexeyyuditsky.test.screen.graphql.domain.FetchCountryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindFetchCountryUseCase(fetchCountryUseCase: FetchCountryUseCase.Base): FetchCountryUseCase

    @Binds
    @Singleton
    abstract fun bindFetchCountriesUseCase(fetchCountriesUseCase: FetchCountriesUseCase.Base): FetchCountriesUseCase

}