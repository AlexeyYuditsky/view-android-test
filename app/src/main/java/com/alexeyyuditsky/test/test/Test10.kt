package com.alexeyyuditsky.test.test

fun main() {
    val a = A()
    val b = B()
    val alarmHelper = AlarmHelper

    AlarmHelper.init(a, b)

    val test1 = AlarmHelper
    val test2 = AlarmHelper

    println(test1.hashCode())
    println(test2.hashCode())
}

object AlarmHelper {

    private lateinit var applicationContext: A
    private lateinit var alarmManager: B

    fun init(context: A, alarmManager: B) {
        applicationContext = context
        AlarmHelper.alarmManager = alarmManager
    }
}

class A
class B