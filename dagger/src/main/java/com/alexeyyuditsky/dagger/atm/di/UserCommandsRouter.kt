package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.Account
import com.alexeyyuditsky.dagger.atm.core.CommandRouter
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [UserCommandsModule::class])
interface UserCommandsRouter {

    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Account): UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule

}