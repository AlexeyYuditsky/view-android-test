package com.alexeyyuditsky.test.example

interface Result123 {
    fun execute(str: String): String
}

class Test123 {
    fun setResult(result: Result123) {
        println(result)
    }
}

fun main() {
    val a = Test123()
    val obj = object : Result123 {
        override fun execute(str: String): String {
            return str + "123"
        }
    }
    a.setResult(obj)
}