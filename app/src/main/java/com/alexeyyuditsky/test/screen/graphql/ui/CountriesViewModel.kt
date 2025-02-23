package com.alexeyyuditsky.test.screen.graphql.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexeyyuditsky.test.screen.graphql.domain.FetchCountriesUseCase
import com.alexeyyuditsky.test.screen.graphql.domain.FetchCountryUseCase
import com.alexeyyuditsky.test.screen.graphql.ui.data.CountriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val fetchCountriesUseCase: FetchCountriesUseCase,
    private val fetchCountryUseCase: FetchCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val countries = fetchCountriesUseCase.invoke()
            _state.update { it.copy(countries = countries, isLoading = false) }
        }
    }

    fun selectCountry(code: String) = viewModelScope.launch {
        val selectedCountry = fetchCountryUseCase.invoke(code)
        _state.update { it.copy(selectedCountry = selectedCountry) }
    }

    fun dismissCountryDialog() {
        _state.update { it.copy(selectedCountry = null) }
    }

}