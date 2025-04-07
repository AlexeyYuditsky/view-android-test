package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {

    private val accounts = hashMapOf<String, Account>()

    fun getAccount(username: String): Account =
        accounts.computeIfAbsent(username) { username: String ->
            Account(username)
        }

}