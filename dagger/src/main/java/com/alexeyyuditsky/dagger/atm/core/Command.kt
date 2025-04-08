package com.alexeyyuditsky.dagger.atm.core

interface Command {

    fun handleInput(input: List<String>): Result

}