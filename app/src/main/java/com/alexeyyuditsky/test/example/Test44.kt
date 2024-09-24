package com.alexeyyuditsky.test.example

infix fun Int.times(str: String) = str.repeat(this)

class Person(val name: String) {
    infix fun greet(greeting: String) {
        println("$greeting, $name!")
    }
}

fun main() {
    val person = Person("Alice")
    person.greet("Hello")
    person greet "Hello"

    println(2.times("Hi "))
    println(2 times "Hi ")
}