package com.alexeyyuditsky.dagger.atm.core

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {

    private val accounts = hashMapOf<String, Account>()

    fun getAccount(username: String): Account =
        accounts.computeIfAbsent(username) { username: String ->
            Account(username)
        }

    class Account(
        val username: String
    ) {

        private var balance: BigDecimal = BigDecimal.ZERO

        fun deposit(amount: BigDecimal) {
            balance = balance.add(amount)
        }

    }

}