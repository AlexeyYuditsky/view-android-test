package com.alexeyyuditsky.test.example

class Livelock {
    private var thread1Active = true
    private var thread2Active = true

    fun thread1() {
        while (thread1Active) {
            if (thread2Active) {
                println("Thread 1: Thread 2 is active, I'll wait.")
                Thread.sleep(100)
                continue
            }
            println("Thread 1: Finished work.")
            thread1Active = false
        }
    }

    fun thread2() {
        while (thread2Active) {
            if (thread1Active) {
                println("Thread 2: Thread 1 is active, I'll wait.")
                Thread.sleep(100)
                continue
            }
            println("Thread 2: Finished work.")
            thread2Active = false
        }
    }
}

fun main() {
    val example = Livelock()
    Thread { example.thread1() }.start()
    Thread { example.thread2() }.start()
}
