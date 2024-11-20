package com.alexeyyuditsky.test.example.other.systemDesign.oneTask

fun main()  {
    val device = BleDevice.Base()
    val commandExecutor = CommandExecutorImpl(device)

    repeat(10) { screen ->
        commandExecutor.requestAsync("battery_status") { response ->
            println("Screen $screen received: $response")
        }
    }

    Thread.sleep(2000)
}
