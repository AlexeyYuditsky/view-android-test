package com.alexeyyuditsky.test.example

class DeadlockExample {

    private val resource1 = Any()
    private val resource2 = Any()

    fun method1() = synchronized(resource1) {
        println("Method1 захватил resource1")

        synchronized(resource2) {
            println("Method1 захватил resource2")
        }
    }

    fun method2() = synchronized(resource2) {
        println("Method2 захватил resource2")

        synchronized(resource1) {
            println("Method2 захватил resource1")
        }
    }
}

fun main() {
    val example = DeadlockExample()

    val thread1 = Thread { example.method1() }
    val thread2 = Thread { example.method2() }

    thread1.start()
    thread2.start()
}