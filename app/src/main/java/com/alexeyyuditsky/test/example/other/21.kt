package com.alexeyyuditsky.test.example.other

import androidx.lifecycle.ViewModel

private val hashMap = HashMap<Int, String>()

fun main() {
    hashMap[1] = "one"
    hashMap[2] = "two"
    hashMap[3] = "three"
    println(hashMap)

    test(1,2,3)

    println(A::class.java)
}

class A : ViewModel()

fun test(vararg values: Int) {
    values.forEach {
        hashMap.remove(it)
        println(hashMap)
    }
}