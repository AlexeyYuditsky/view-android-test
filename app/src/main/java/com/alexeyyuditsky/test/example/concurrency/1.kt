package com.alexeyyuditsky.test.example.concurrency

import kotlin.concurrent.thread

abstract class Widget {
    override fun toString(): String {
        return "Widget"
    }

    open fun doSmth() {
        println(toString() + Thread.currentThread().name)
    }
}

class LoggingWidget : Widget() {
    override fun toString(): String {
        return "LoggingWidget"
    }

    @Synchronized
    override fun doSmth() {
        println(toString() + Thread.currentThread().name)
        super.doSmth()
    }
}

fun main() {
    val logging = LoggingWidget()

    for (index in 0 until 100000) {
        thread {
            logging.doSmth()
        }
    }

}