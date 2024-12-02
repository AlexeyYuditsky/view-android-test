package com.alexeyyuditsky.test.example.other

interface MyUseCase {
    operator fun invoke()
    class Base : MyUseCase {
        override fun invoke() { /* реализация */ }
    }
}

interface FakeMyUseCase : MyUseCase {
    fun getCountCall(): Int
    class MyFakeMyUseCase : FakeMyUseCase {
        private var count = 0
        override fun invoke() { count++ }
        override fun getCountCall(): Int = count
    }
}

class VM(private val myUseCase: MyUseCase) {
    fun callUseCase() { myUseCase.invoke() }
}

fun main() {
    val fakeUseCase = FakeMyUseCase.MyFakeMyUseCase()
    val vm = VM(fakeUseCase)

    vm.callUseCase()

    val actual = fakeUseCase.getCountCall()
    val expected = 1
    println(actual)
    println(expected)
}