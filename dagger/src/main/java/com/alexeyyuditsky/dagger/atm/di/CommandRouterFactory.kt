package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.CommandRouter
import dagger.Component

@Component(
    modules = [
        LoginCommandModule::class,
        HelloWorldCommandModule::class,
        SystemOutModule::class,
    ]
)
interface CommandRouterFactory {

    fun route(): CommandRouter

}