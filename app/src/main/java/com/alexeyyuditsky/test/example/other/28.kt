package com.alexeyyuditsky.test.example.other

class MyClass {
    init {
        println("init class ${System.nanoTime()}") // second
    }

    companion object {
        init {
            println("init companion ${System.nanoTime()}") // first
        }
    }
}

fun main() {
    MyClass()
}