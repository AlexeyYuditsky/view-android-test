package com.alexeyyuditsky.test.example

class MyClass {
    var a = 5
        set(value) {
            println("hello")
            field = value
        }
}

fun main() {
    val myClass = MyClass()
    println(myClass.a)

}