package com.alexeyyuditsky.test.example.other.systemDesign.oneTask

import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val device = BleDevice.Base()
    val commandExecutor = CommandExecutorImpl(device, this)

    val jobs = List(10) {
        launch {
            commandExecutor.requestAsync("battery_status") { response ->
                println("Screen $it received: $response")
            }
        }
    }

    jobs.joinAll()
}
