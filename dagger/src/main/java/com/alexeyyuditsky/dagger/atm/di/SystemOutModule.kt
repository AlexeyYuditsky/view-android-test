package com.alexeyyuditsky.dagger.atm.di

import com.alexeyyuditsky.dagger.atm.core.Outputter
import dagger.Module
import dagger.Provides

@Module
class SystemOutModule {

    @Provides
    fun textOutputter(): Outputter =
        Outputter { s: String -> println(s) }

}