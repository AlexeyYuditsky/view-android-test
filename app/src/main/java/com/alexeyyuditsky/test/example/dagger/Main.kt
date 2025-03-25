package com.alexeyyuditsky.test.example.dagger

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val commandRouter = CommandRouter()
    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        commandRouter.route(line)
    }
}