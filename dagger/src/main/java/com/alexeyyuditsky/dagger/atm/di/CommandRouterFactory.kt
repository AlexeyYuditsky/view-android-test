package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.CommandRouter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LoginCommandModule::class,
        HelloWorldCommandModule::class,
        SystemOutModule::class,
        UserCommandsModule::class
    ]
)
interface CommandRouterFactory {

    fun route(): CommandRouter

}