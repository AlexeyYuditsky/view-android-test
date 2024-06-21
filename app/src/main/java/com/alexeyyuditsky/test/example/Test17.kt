package com.alexeyyuditsky.test.example

class Success<T>(val res: T?) {
    override fun hashCode(): Int = javaClass.hashCode() + 31 * res.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        (other as Success<*>)
        return this.res == other.res
    }
}

fun main() {
    val regex =Regex("[a-zA-Z\\d\\s-]+")
    println("2f".matches(regex))
}