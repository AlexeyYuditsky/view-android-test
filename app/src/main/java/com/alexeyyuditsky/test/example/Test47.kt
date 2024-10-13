package com.alexeyyuditsky.test.example

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis

class Counter(
    var count: AtomicLong
) {
    fun increment() {
        count.incrementAndGet()
    }

    fun decrement() {
        count.decrementAndGet()
    }
}

fun main() {
    val counter = Counter(AtomicLong(0))

    val runnable1 = Runnable {
        for (i in 0..10000000) {
            counter.increment()
        }
    }
    val runnable2 = Runnable {
        for (i in 0..10000000) {
            counter.decrement()
        }
    }

    val executor = Executors.newCachedThreadPool()
    val res = measureTimeMillis {
        executor.execute(runnable1)
        executor.execute(runnable2)
        executor.shutdown()
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)
        println("Значение счетчика: ${counter.count}")
    }
    println(res)
}