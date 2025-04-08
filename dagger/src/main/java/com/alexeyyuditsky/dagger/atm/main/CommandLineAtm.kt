package com.alexeyyuditsky.dagger.atm.main

import com.alexeyyuditsky.dagger.atm.di.DaggerCommandProcessorFactory
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val commandProcessorFactory = DaggerCommandProcessorFactory.create()
    val commandProcessor = commandProcessorFactory.commandProcessor()

    while (scanner.hasNextLine()) {
        val status = commandProcessor.process(scanner.nextLine())
        println("Status: $status")
    }
}