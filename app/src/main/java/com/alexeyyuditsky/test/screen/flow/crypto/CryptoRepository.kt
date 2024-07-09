package com.alexeyyuditsky.test.screen.flow.crypto

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CryptoRepository {

    private val currencyNames = listOf("BTC", "ETH", "USDT", "BNB", "USDC")
    private val currencyList = mutableListOf<Currency>()

    fun getCurrencyList(): Flow<List<Currency>> = flow {
        emit(currencyList.toList())
        while (true) {
            delay(3000)
            generateCurrentList()
            emit(currencyList.toList())
        }
    }

    private fun generateCurrentList() {
        val prices = List(currencyNames.size) {
            Random.nextInt(1000, 2000)
        }
        val newData = List(currencyNames.size) {
            Currency(
                name = currencyNames[it],
                price = prices[it]
            )
        }
        currencyList.clear()
        currencyList.addAll(newData)
    }

}