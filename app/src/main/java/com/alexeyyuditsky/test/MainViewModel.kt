package com.alexeyyuditsky.test

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun saveState() {
        savedStateHandle["key"] = "SAVE_STATE"
    }

    fun restoreState() {
        log(savedStateHandle.get<String>("key"))
    }
}