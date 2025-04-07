package com.alexeyyuditsky.dagger.atm.core

import java.math.BigDecimal

class Account(
    val username: String
) {

    var balance: BigDecimal = BigDecimal.ZERO
        private set

    fun deposit(amount: Long) {
        balance = balance.add(BigDecimal(amount))
    }

}