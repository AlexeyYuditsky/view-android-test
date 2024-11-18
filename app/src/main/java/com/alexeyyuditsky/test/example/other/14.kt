package com.alexeyyuditsky.test.example.other

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.time.measureTime

@Serializable
data class User(
    val name: String,
    val age: Int
)

fun main() {
    val jsonString = """{"name": "Alex", "age": "20"}"""

    val kotlinSerializableTime = measureTime {
        val user = Json.decodeFromString<User>(jsonString)
        println(user)
    }
    println(kotlinSerializableTime)
}

