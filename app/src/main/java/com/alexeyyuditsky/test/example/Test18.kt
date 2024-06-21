package com.alexeyyuditsky.test.example

abstract class Base {
    protected var a = 5
}

class Help : Base() {
    fun test() {
        a = 10
    }
}

class Cara {
    fun change(help:Help) {
       // help.a = 7
       // println(help.a)
    }
}

fun main() {
    val help = Help()
    help.test()
    val cara = Cara()
    cara.change(help)
}