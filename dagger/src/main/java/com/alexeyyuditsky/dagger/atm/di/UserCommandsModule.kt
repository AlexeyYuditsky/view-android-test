package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.Command
import com.alexeyyuditsky.dagger.atm.core.DepositCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    fun depositCommand(depositCommand: DepositCommand): Command

}