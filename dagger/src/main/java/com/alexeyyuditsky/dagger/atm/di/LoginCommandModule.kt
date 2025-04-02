package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.Command
import com.alexeyyuditsky.dagger.atm.core.LoginCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    fun loginCommand(loginCommand: LoginCommand): Command

}