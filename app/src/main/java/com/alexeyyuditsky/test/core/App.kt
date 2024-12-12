package com.alexeyyuditsky.test.core

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Context
import android.os.Bundle
import android.os.Trace
import com.gu.toolargetool.TooLargeTool

interface LifeCycleCallback : ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
    override fun onActivityStarted(activity: Activity) = Unit
    override fun onActivityResumed(activity: Activity) = Unit
    override fun onActivityPaused(activity: Activity) = Unit
    override fun onActivityStopped(activity: Activity) = Unit
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
}

class App : Application(), LifeCycleCallback {

    init {
        log("Application INIT", "a")
    }

    override fun onCreate() {
        log("Application onCreate", "a")
        super.onCreate()
        TooLargeTool.startLogging(this)
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityDestroyed(activity: Activity) {
        log("App onDestroy")
    }
}