package com.alexeyyuditsky.test.example

interface Worker {
    fun work()
    fun takeVacation()
}

class Engineer : Worker {
    override fun work() {
        println("Engineering work in progress...")
    }

    override fun takeVacation() {
        println("Taking a vacation!")
    }
}

class Manager(worker: Worker) : Worker by worker {
    fun manage() {
        println("Managing the project...")
    }
}

fun main() {
    val engineer = Engineer()
    val manager = Manager(engineer)

    manager.work()
    manager.takeVacation()

    manager.manage()
}