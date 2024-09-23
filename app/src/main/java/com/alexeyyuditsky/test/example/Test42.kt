package com.alexeyyuditsky.test.example

fun main() {
    val test = ListenerManager()

    // Передаем лямбду как Runnable
    test.addListener { println("Listener 1 triggered") }
    test.removeListener { println("Listener 1 triggered") }  // Не удалит listener

    // Решение: сохраняем лямбду в переменную
    val listener2 = Runnable { println("Listener 2 triggered") }
    test.addListener(listener2)
    test.removeListener(listener2) // Успешно удалит listener
}