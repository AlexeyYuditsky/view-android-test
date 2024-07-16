package com.alexeyyuditsky.test.screen.flow.crypto

import com.alexeyyuditsky.test.core.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CryptoRepository {

    private val currencyNames = listOf("BTC", "ETH", "USDT", "BNB", "USDC")
    private val currencyList = mutableListOf<Currency>()

    private val refreshEvents = MutableSharedFlow<Unit>()

    fun loadData(): Flow<List<Currency>> = flow {
        delay(1500)
        generateCurrentList()
        emit(currencyList.toList())

        refreshEvents.collect {
            delay(1500)
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

    suspend fun refreshCrypto() = refreshEvents.emit(Unit)
}