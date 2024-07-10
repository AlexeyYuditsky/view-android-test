package com.alexeyyuditsky.test.screen.flow.crypto

import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository()

    val state: Flow<State> = repository.getCurrencyList()
        .filter { it.isNotEmpty() }
        .map { State.Content(it) as State }
        .onStart {
            log("onStart")
            emit(State.Loading)
        }
        .onEach { log("onEach") }
        .onCompletion { log("onCompletion") }
}