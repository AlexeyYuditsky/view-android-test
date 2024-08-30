package com.alexeyyuditsky.test.example

fun main() {
    var operation: (String) -> String
    val operation1 = { str: String -> str }
    val operation2 = fun(str: String): String { return "" }
    val operation3 = ::test3
    val operation4 = Hello { str -> "hello $str" }

    operation = operation1
    operation = operation2
    operation = operation3
    operation = operation4::test
}

fun test3(str: String): String = str

fun interface Hello {
    fun test(str: String): String
    fun test2(str: String): String = str
}