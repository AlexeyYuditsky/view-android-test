package com.alexeyyuditsky.test.test

interface Car {
    fun draw()
}

class SportCar : Car {
    override fun draw() = println("SportCar")
}

class UnknownCar : Car {
    override fun draw() = println("UnknownCar")
}

abstract class CarDecorator(protected var decorated: Car) : Car {
    override fun draw() = decorated.draw()
}

class BlueCarDecorator(decorated: Car) : CarDecorator(decorated) {
    override fun draw() {
        decorated.draw()
        setColor()
    }

    private fun setColor() = println("Color: red")
}

fun main() {
    val sportCar = SportCar()
    val blueUnknownCar = BlueCarDecorator(UnknownCar())
    sportCar.draw()
    println()
    blueUnknownCar.draw()
}