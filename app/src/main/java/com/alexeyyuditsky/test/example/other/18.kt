package com.alexeyyuditsky.test.example.other

fun main() {
    val all = Node(1, Node(2, Node(3, null)))
    println(all)

    all.next = all.next?.next

    println(all)
}

data class Node(
    var value: Int,
    var next: Node?
)