package com.alexeyyuditsky.test.example

fun main() {
    val a = com.alexeyyuditsky.test.example.A()
    val b = com.alexeyyuditsky.test.example.B()
    val alarmHelper = com.alexeyyuditsky.test.example.AlarmHelper

    com.alexeyyuditsky.test.example.AlarmHelper.init(a, b)

    val test1 = com.alexeyyuditsky.test.example.AlarmHelper
    val test2 = com.alexeyyuditsky.test.example.AlarmHelper

    println(test1.hashCode())
    println(test2.hashCode())
}

object AlarmHelper {

    private lateinit var applicationContext: com.alexeyyuditsky.test.example.A
    private lateinit var alarmManager: com.alexeyyuditsky.test.example.B

    fun init(context: com.alexeyyuditsky.test.example.A, alarmManager: com.alexeyyuditsky.test.example.B) {
        com.alexeyyuditsky.test.example.AlarmHelper.applicationContext = context
        com.alexeyyuditsky.test.example.AlarmHelper.alarmManager = alarmManager
    }
}

class A
class B