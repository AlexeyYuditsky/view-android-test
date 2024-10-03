package com.alexeyyuditsky.test.example

fun main() {
    Habr()
}

class Habr {

    init {
        searchMagnit() // 2
    }

    constructor() {
        println("constructor") // 5
    }

    init {
        println("Habr init") // 4
    }

    companion object {
        init {
            println("companion init") // 1
        }

        fun searchMagnit() {
            println("searchMagnit") // 3
        }
    }

}