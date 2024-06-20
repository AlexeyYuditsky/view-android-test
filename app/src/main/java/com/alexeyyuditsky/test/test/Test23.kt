package com.alexeyyuditsky.test.test

val lock1 = Any()
val lock2 = Any()

fun main() {
    val thread1 = Thread {
        synchronized(lock1) {
            println("Thread 1: Holding lock 1...")

            // Пытаемся захватить lock2
            Thread.sleep(100)
            println("Thread 1: Waiting for lock 2...")
            synchronized(lock2) {
                println("Thread 1: Holding lock 1 & 2...")
            }
        }
    }

    val thread2 = Thread {
        synchronized(lock2) {
            println("Thread 2: Holding lock 2...")

            // Пытаемся захватить lock1
            Thread.sleep(100)
            println("Thread 2: Waiting for lock 1...")
            synchronized(lock1) {
                println("Thread 2: Holding lock 2 & 1...")
            }
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}


