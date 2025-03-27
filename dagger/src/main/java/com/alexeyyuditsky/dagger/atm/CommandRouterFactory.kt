package com.alexeyyuditsky.dagger.atm

import dagger.Binds
import dagger.Component
import dagger.Module

@Component(modules = [HelloWorldModule::class])
interface CommandRouterFactory {

    fun route(): CommandRouter

}

@Module
interface HelloWorldModule {

    @Binds
    fun helloWorldCommand(helloWorld: Command.HelloWorld): Command

}