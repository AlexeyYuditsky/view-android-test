package com.alexeyyuditsky.test.example.other

inline fun execute(noinline block: () -> Unit) {
    val res = block::class.simpleName
    println(res)
}
fun main() {
    execute {  }
}