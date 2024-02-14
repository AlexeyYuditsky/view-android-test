package com.alexeyyuditsky.test.test

import java.math.BigDecimal

open class Account {
    open fun balance(numberAccount: String?): BigDecimal = BigDecimal.TEN
    open fun refill(numberAccount: String?, sum: BigDecimal?) {}
}

open class PaymentAccount : Account() {
    open fun payment(numberAccount: String?, sum: BigDecimal?) {}
}

class SalaryAccount : PaymentAccount() {
    override fun balance(numberAccount: String?): BigDecimal = BigDecimal.TEN
    override fun refill(numberAccount: String?, sum: BigDecimal?) {}
    override fun payment(numberAccount: String?, sum: BigDecimal?) {}
}

class DepositAccount : Account() {
    override fun balance(numberAccount: String?): BigDecimal = BigDecimal.TEN
    override fun refill(numberAccount: String?, sum: BigDecimal?) {}
}

fun main() {
    var account = PaymentAccount()
    account.balance("a")
    account.refill("a", BigDecimal.TEN)

    account = SalaryAccount()
    account.balance("a")
    account.refill("a", BigDecimal.TEN)
}