package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

suspend fun main() {
    val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    val deviceA = DeviceA()
    val deviceB = DeviceB()
    val deviceC = DeviceC()

    val job1 = coroutineScope.launch {
        println("start1")
        CommandExecutor.Base(deviceA).requestAsync("URL1", ::asyncResult)
    }

    val job2 = coroutineScope.launch {
        println("start2")
        CommandExecutor.Base(deviceB).requestAsync("URL2", ::asyncResult)
    }

    val job3 = coroutineScope.launch {
        println("start3")
        CommandExecutor.Base(deviceC).requestAsync("URL1", ::asyncResult)
    }

    job1.join()
    job2.join()
    job3.join()
}

private fun asyncResult(response: String) = println(response)

class DeviceA : BleDevice {
    override fun requestSync(url: String): String = "80"
}

class DeviceB : BleDevice {
    override fun requestSync(url: String): String = "81"
}

class DeviceC : BleDevice {
    override fun requestSync(url: String): String = "82"
}

interface BleDevice {
    //@Synchronized
    fun requestSync(url: String): String
}

interface CommandExecutor {

    fun requestAsync(url: String, onResponse: (String) -> Unit)

    class Base(
        private val bleDevice: BleDevice
    ) : CommandExecutor {

        private val requestCache = ConcurrentHashMap<String, Deferred<String>>()
        private val coroutineScope = CoroutineScope(Dispatchers.IO)

        override fun requestAsync(url: String, onResponse: (String) -> Unit) {
            val deferredResponse = requestCache[url] ?: run {
                val newDeferred = coroutineScope.async { bleDevice.requestSync(url) }
                requestCache[url] = newDeferred
                return@run newDeferred
            }

            coroutineScope.launch {
                val response = deferredResponse.await()
                onResponse(response)
                requestCache.remove(url)
            }
        }

    }
}