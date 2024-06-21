package com.alexeyyuditsky.test.example

import java.math.BigDecimal

class Cash {
    fun doTransaction(amount: BigDecimal?) {}
}

class Shop(private val payments: Payments) {
    fun doPayment(order: Any?, amount: BigDecimal?) { payments.doTransaction(amount) }
}

/*---------------------------------------------*/

interface Payments {
    fun doTransaction(amount: BigDecimal?)
}

class Cash2 : Payments {
    override fun doTransaction(amount: BigDecimal?) {}
}

class BankCard : Payments {
    override fun doTransaction(amount: BigDecimal?) {}
}

class PayByPhone : Payments {
    override fun doTransaction(amount: BigDecimal?) {}
}