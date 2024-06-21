package com.alexeyyuditsky.test.screen.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository {

    private val users = mutableListOf("Alexey, Ivan, Andrey")

    suspend fun addUser(user: String) {
        delay(500)
        users.add(user)
    }

    fun loadUsers(): Flow<List<String>> = flow {
        while (true) {
            delay(500)
            emit(users.toList())
        }
    }
}