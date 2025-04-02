package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.Command
import com.alexeyyuditsky.dagger.atm.core.HelloWorldCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface HelloWorldCommandModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    fun helloWorldCommand(helloWorldCommand: HelloWorldCommand): Command

}