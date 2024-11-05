package com.alexeyyuditsky.test.example.other.isp

interface Price {
    val price: Double
}

interface Discount {
    val discountPercentage: Int
    fun discountedPrice(): Double
}

class Product(
    override val price: Double,
    override val discountPercentage: Int
) : Price, Discount {
    override fun discountedPrice(): Double {
        return price * (1 - discountPercentage / 100.0)
    }
}

fun main() {
    val product = Product(price = 1000.0, discountPercentage = 20)
    println(product.discountedPrice())
}