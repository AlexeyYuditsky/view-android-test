package com.alexeyyuditsky.test.example.concurrency

open class Widget {
    override fun toString(): String {
        return "Widget"
    }

    @Synchronized
    open fun doSmth() {
        println(toString())
    }
}

class LoggingWidget : Widget() {
    override fun toString(): String {
        return "LoggingWidget"
    }

    @Synchronized
    override fun doSmth() {
        println(toString())
        super.doSmth()
    }
}

fun main() {
    val logging = LoggingWidget()
    logging.doSmth()
}