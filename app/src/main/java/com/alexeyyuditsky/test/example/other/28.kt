package com.alexeyyuditsky.test.example.other

class MyClass {
    companion object {
        init {
            println("init")
        }
    }
}

fun main() {
    val a = MyClass()

}