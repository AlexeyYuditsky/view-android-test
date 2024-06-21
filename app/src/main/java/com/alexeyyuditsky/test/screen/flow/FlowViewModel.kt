package com.alexeyyuditsky.test.screen.flow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _user = MutableLiveData<List<String>>()
    val user: LiveData<List<String>> = _user

    init {
        loadUsers()
    }

    private fun loadUsers() = viewModelScope.launch {
        repository.loadUsers().collect {
            _user.value = it
        }
    }

    fun addUser(user: String) = viewModelScope.launch {
        repository.addUser(user)
    }

}