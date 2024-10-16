package com.alexeyyuditsky.test.example

class Task(val id: Int, val name: String)

fun main() {
    val task1 = Task(1, "Alex")
    val task2 = Task(1, "Alex")
    val hashSet = HashSet<Task>()
    hashSet.add(task1)
    hashSet.add(task2)

    println(hashSet)
}