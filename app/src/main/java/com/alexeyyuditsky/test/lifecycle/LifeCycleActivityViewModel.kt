package com.alexeyyuditsky.test.lifecycle

import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log

class LifeCycleActivityViewModel : ViewModel() {

    init {
        log("LifeCycleActivityViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        log("LifeCycleActivityViewModel onCleared")
    }
}