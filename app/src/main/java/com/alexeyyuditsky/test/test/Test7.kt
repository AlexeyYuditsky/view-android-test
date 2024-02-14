package com.alexeyyuditsky.test.test

enum class CargoSpaceType {
    PAID_WAYBILL, VSD, VPD;

    override fun toString(): String = name.lowercase()
}

fun main() {
    val type1 = CargoSpaceType.PAID_WAYBILL
    val type2 = CargoSpaceType.VPD
    val type3 = CargoSpaceType.VSD
    println(type1)
    println(type2)
    println(type3)
}