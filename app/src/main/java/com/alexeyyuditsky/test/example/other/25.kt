package com.alexeyyuditsky.test.example.other

fun main() {
    val hashMap = HashMap<String, Int>(8)
    hashMap["A"] = 1
    hashMap["B"] = 2
    hashMap["C"] = 3
    println(hashMap["C"])
    println(hashMap.entries)
    println(hashMap.entries.find { it.value == 3 })
}