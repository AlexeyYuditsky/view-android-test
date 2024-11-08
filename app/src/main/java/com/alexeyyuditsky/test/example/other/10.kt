package com.alexeyyuditsky.test.example.other

interface Printer {
    fun print()
    class Base : Printer { override fun print() = println("BASE") }
    class Test : Printer { override fun print() = println("TEST") }
}

class Document : Printer by Printer.Test()

fun main() {
    val doc = Document()
    doc.print() // TEST
}