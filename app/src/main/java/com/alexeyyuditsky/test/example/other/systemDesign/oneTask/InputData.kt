package com.alexeyyuditsky.test.example.other.systemDesign.oneTask

interface CommandExecutor {
    fun requestAsync(url: String, onResponse: (String) -> Unit)
}

interface BleDevice {

    fun requestSync(url: String): String

    class Base : BleDevice {
        override fun requestSync(url: String): String {
            Thread.sleep(1000)
            return "Battery: 80%"
        }
    }

}