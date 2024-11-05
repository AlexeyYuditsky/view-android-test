package com.alexeyyuditsky.test.example.other.lsp

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

fun checkObjects(product1: Price, product2: Discount) {
    println(product1.price)
    println(product2.discountedPrice())
}

fun main() {
    val productPrice: Price = Product(price = 1000.0, discountPercentage = 20)
    val productDiscount: Discount = Product(price = 1000.0, discountPercentage = 20)
    checkObjects(productPrice, productDiscount)
}