package com.alexeyyuditsky.test.test

import androidx.fragment.app.ListFragment
import java.util.Calendar

fun main() {
    val list = ListFragment::class.java
    val list2 = ListFragment::class.java
    val list3 = ListFragment::class.java

    println(list == list3)
    println(list2 == list)
    println(list3 == list2)
}