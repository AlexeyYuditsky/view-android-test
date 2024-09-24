package com.alexeyyuditsky.test.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexeyyuditsky.test.core.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val viewModelScope2 = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    init {
        log("MainViewModel created")
        viewModelScope
    }

    fun saveState() {
        savedStateHandle["key"] = "SAVE_STATE"
    }

    fun restoreState() {
        log(savedStateHandle.get<String>("key"))
    }

    override fun onCleared() {
        super.onCleared()
        log("MainViewModel onCleared")
    }
}