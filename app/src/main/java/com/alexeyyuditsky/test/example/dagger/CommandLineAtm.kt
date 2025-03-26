package com.alexeyyuditsky.test.example.dagger

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.route()

    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        val result = commandRouter.route(line)
    }
}