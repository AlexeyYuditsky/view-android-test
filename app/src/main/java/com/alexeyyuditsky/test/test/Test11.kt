package com.alexeyyuditsky.test.test

fun main() {
    val str = "20240215 07:38:09\t-122.084\t37.4219983\t\t\t\t\t-122.084;37.4219983\t2EAC760D057EDDE55C4E7B103F772BE4"
    val modifiedString = str.replaceFirst("\\t(.*?)\\t".toRegex(), "\t999\t")
    println(str)
    println(modifiedString)
}