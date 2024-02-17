package com.alexeyyuditsky.test.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        log("MainViewModel created")
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