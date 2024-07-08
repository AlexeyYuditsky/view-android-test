package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository()

    private val _state = MutableLiveData<State>(State.Initial)
    val state: LiveData<State> get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        repository.getCurrencyList()
            .onStart { if (_state.value !is State.Content) _state.value = State.Loading }
            .filter { it.isNotEmpty() }
            .onEach { _state.value = State.Content(currencyList = it) }
            .launchIn(viewModelScope)
    }
}