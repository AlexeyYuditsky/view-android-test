package com.alexeyyuditsky.test.example.other

fun main() {
    Test.value
}

class Test {
    companion object {
        @JvmStatic
        val value = 5

        @JvmStatic
        fun test() {

        }
    }
}