package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.CommandProcessor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LoginCommandModule::class,
        HelloWorldCommandModule::class,
        UserCommandsModule::class,
        SystemOutModule::class,
    ]
)
interface CommandProcessorFactory {

    fun commandProcessor(): CommandProcessor

}