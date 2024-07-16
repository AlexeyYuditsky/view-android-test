package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository()

    private val loadingFlow = MutableSharedFlow<State>()

    val state: Flow<State> = repository.loadData()
        .filter { it.isNotEmpty() }
        .map { State.Content(it) as State }
        .onStart { emit(State.Loading) }
        .mergeWith(loadingFlow)

    private fun <T> Flow<T>.mergeWith(flow: Flow<T>): Flow<T> = merge(this, flow)

    fun refreshCrypto() = viewModelScope.launch {
        loadingFlow.emit(State.Loading)
        repository.refreshCrypto()
    }
}