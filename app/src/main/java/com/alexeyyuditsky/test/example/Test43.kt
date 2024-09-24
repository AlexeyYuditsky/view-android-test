package com.alexeyyuditsky.test.example

class Box1<out T>
class Box2<in T>
class Box3<T>

fun main() {
    // ковариативность (out) (? extends T)
    val box11: Box1<Int> = Box1()
    val box12: Box1<Number> = box11

    // контравариативность (in) (? super T)
    val box21: Box2<Number> = Box2()
    val box22: Box2<Int> = box21

    // инвариативность
    val box31: Box3<Int> = Box3()
}