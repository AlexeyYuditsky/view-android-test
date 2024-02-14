package com.alexeyyuditsky.promocodes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexeyyuditsky.promocodes.domain.FetchPromocodesUseCase
import kotlinx.coroutines.launch

class PromocodesViewModel(
    private val fetchPromocodesUseCase: FetchPromocodesUseCase = FetchPromocodesUseCase()
) : ViewModel() {

    private val _state = SingleLiveEvent<State>()
    val state: LiveData<State> get() = _state

    fun fetchPromocodes() {
        _state.value = State.Loading
        viewModelScope.launch {
            _state.value = fetchPromocodesUseCase.invoke()
        }
    }
}