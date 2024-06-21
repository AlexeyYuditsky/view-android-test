package com.alexeyyuditsky.test.screen.lifecycle

import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log

class LifeCycleFragment2ViewModel : ViewModel() {

    init {
        log("LifeCycleFragment2ViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        log("LifeCycleFragment2ViewModel onCleared")
    }
}