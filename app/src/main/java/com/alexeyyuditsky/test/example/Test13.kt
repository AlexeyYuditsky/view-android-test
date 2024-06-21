package com.alexeyyuditsky.test.example

abstract class Anonnim {
    abstract fun show()
}

fun main() {
    AninimImpl().show()
}

class AninimImpl : Anonnim() {
    override fun show() {
        println(javaClass.simpleName)
    }
}