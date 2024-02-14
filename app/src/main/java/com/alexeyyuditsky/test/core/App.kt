package com.alexeyyuditsky.test.core

import android.app.Application
import com.gu.toolargetool.TooLargeTool

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        TooLargeTool.startLogging(this)
    }
}