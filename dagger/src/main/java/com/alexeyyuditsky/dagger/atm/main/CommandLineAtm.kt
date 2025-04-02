package com.alexeyyuditsky.dagger.atm.main

import com.alexeyyuditsky.dagger.atm.di.DaggerCommandRouterFactory
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.route()

    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        val result = commandRouter.route(line)
        println("Result: ${result.status}")
    }
}