package com.alexeyyuditsky.test.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BoundService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val binder = LocalBinder()

    val liveData = MutableLiveData<String>()

    inner class LocalBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

    fun performBackgroundTask() {
        coroutineScope.launch {
            repeat(10) { index ->
                val result = longRunningTask(index + 1)
                withContext(Dispatchers.Main) { liveData.value = result }
            }
        }
    }

    private suspend fun longRunningTask(progress: Int): String {
        delay(500)
        return progress.toString()
    }

    override fun onCreate() {
        super.onCreate()
        println("boundService: onCreate")
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onDestroy() {
        super.onDestroy()
        println("boundService: onDestroy")
        coroutineScope.cancel()
    }

    companion object {
        private const val KEY_ARG = "title"

        fun createServiceIntent(context: Context?, title: String): Intent {
            return Intent(context, BoundService::class.java).apply {
                putExtra(KEY_ARG, title)
            }
        }
    }

}