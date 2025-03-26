package com.alexeyyuditsky.test.example.dagger

import dagger.Component

@Component
interface CommandRouterFactory {

    fun route(): CommandRouter

}