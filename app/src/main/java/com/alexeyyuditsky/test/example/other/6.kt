package com.alexeyyuditsky.test.example.other

class OuterClass {
    private val outerProperty: String = "I am OuterClass property"

    inner class InnerClass {
        fun accessOuterClass() {
            println("Accessing from InnerClass: $outerProperty")
        }
    }

    class NestedClass {
        fun accessOuterClass2() {
          //  println("Accessing from InnerClass: $outerProperty")
        }
    }
}

fun main() {
    //val innerNon = OuterClass.InnerClass()
    val inner = OuterClass().InnerClass()
    inner.accessOuterClass()
}