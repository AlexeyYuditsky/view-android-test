package com.alexeyyuditsky.test.example.concurrency

import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.random.Random

object ServletRequest
object ServletResponse

fun extractFromRequest(req: ServletRequest): BigInteger {
    println("extractFromRequest before sleep: ${Thread.currentThread().name}")
    Thread.sleep(100)
    println("extractFromRequest after sleep: ${Thread.currentThread().name}")
    val randomValue = Random.nextLong(1, 10)
    return BigInteger.valueOf(randomValue)
}

fun factor(i: BigInteger): Array<BigInteger> {
    var num = i
    val factors = mutableListOf<BigInteger>()
    val two = BigInteger.valueOf(2L)

    // Делим число на 2, пока оно четное
    while (num.mod(two) == BigInteger.ZERO) {
        factors.add(two)
        num = num.divide(two)
    }

    // Начинаем проверку нечетных чисел с 3
    var divisor = BigInteger.valueOf(3L)
    while (divisor.multiply(divisor) <= num) {
        while (num.mod(divisor) == BigInteger.ZERO) {
            factors.add(divisor)
            num = num.divide(divisor)
        }
        divisor = divisor.add(two)  // Переход к следующему нечетному числу
    }

    // Если после всех делений у нас осталось число больше 1, то это простое число
    if (num > BigInteger.ONE) {
        factors.add(num)
    }

    return factors.toTypedArray()
}

class CachedFactories {
    private var lastNumber: BigInteger? = null
    private var lastFactors: Array<BigInteger>? = null

    @get:Synchronized
    var hits: Long = 0
        private set

    private var cacheHits: Long = 0

    @Synchronized
    fun getCacheHitRatio(): Double {
        return cacheHits.toDouble() / hits.toDouble()
    }

    fun service(req: ServletRequest, resp: ServletResponse) {
        val i: BigInteger = extractFromRequest(req)
        var factors: Array<BigInteger>? = null
        println("sync before ${Thread.currentThread().name}")
        synchronized(this) {
            println("sync after ${Thread.currentThread().name}")
            ++hits
            if (i == lastNumber) {
                ++cacheHits
                factors = lastFactors?.clone()
            }
        }
        println("sync out ${Thread.currentThread().name}")
        if (factors == null) {
            factors = factor(i)
            synchronized(this) {
                println("sync in ${Thread.currentThread().name}")
                lastNumber = i
                lastFactors = factors?.clone()
            }
            println("sync in out ${Thread.currentThread().name}")
        }
    }
}

fun main() {
    val cachedFactories = CachedFactories()

    for (i in 1..10) {
        thread {
            cachedFactories.service(ServletRequest, ServletResponse)
        }
    }
}