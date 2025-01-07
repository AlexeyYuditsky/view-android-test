package com.alexeyyuditsky.test.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartedService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        coroutineScope.launch {
            val title = intent?.getStringExtra(KEY_ARG)
            println("startedService: start task $title")
            performBackgroundTask()
            println("startedService: stop task")
            stopSelf()
        }
        return START_STICKY
    }

    private suspend fun performBackgroundTask() = delay(2000)

    override fun onDestroy() {
        super.onDestroy()
        println("startedService: onDestroy")
        coroutineScope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private const val KEY_ARG = "title"

        fun createServiceIntent(context: Context?, title: String): Intent {
            return Intent(context, StartedService::class.java).apply {
                putExtra(KEY_ARG, title)
            }
        }
    }

}