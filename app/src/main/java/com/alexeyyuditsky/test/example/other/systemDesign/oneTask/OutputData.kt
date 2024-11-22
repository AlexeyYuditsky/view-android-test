package com.alexeyyuditsky.test.example.other.systemDesign.oneTask

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

class CommandExecutorImpl(
    private val bleDevice: BleDevice,
    private val scope: CoroutineScope
) : CommandExecutor {

    private val mutex = Mutex()
    private val responseCache = mutableMapOf<String, String>()

    override fun requestAsync(
        url: String,
        onResponse: (String) -> Unit
    ) {
        scope.launch {
            try {
                val response = getResponse(url)
                withContext(Dispatchers.Default) {
                    onResponse(response)
                }
            } catch (e: Exception) {
                onResponse(e.message ?: "Unknown error")
            } finally {
                responseCache.clear()
            }
        }
    }

    private suspend fun getResponse(url: String): String {
        return mutex.withLock {
            responseCache[url] ?: run {
                val response = bleDevice.requestSync(url)
                responseCache[url] = response
                response
            }
        }
    }
}