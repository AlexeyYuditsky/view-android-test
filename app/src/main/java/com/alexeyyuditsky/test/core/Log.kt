package com.alexeyyuditsky.test.core

import android.util.Log

fun <T> log(message: T, additionalLog: String = "") {
    Log.d("MyLog$additionalLog", message.toString())
}