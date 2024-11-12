package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    isServerAvailable("")
}

fun isServerAvailable(url: String): Boolean = runBlocking(Dispatchers.IO) {
    try {
        val httpURLConnection = URL("http://lk-test.cse.ru/Cargo5_mob_upd/CargoVersion.txt").openConnection() as HttpURLConnection
        if (httpURLConnection.responseCode in 500..599) {
            httpURLConnection.disconnect()
            false
        } else {
            true
        }
    } catch (e: IOException) {
        false
    }
}