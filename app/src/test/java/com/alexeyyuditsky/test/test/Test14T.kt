package com.alexeyyuditsky.test.test

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions

class Test14Test {

    private var test14: Test14? = null

    @Before
    fun createTest14() {
        test14 = Test14()
    }

    @After
    fun clearTest14() {
        test14 = null
    }

    @Test
    fun test() {
        val a = 2_000_000_000
        val b = 1_000_000_000

        val expected = 3_000_000_000
        val actual = Test14().sum(a, b)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val a = 2_000_000_000
        val b = 1_000_000_000

        val expected = 3_000_000_000
        val actual = Test14().sum(a, b)

        Assertions.assertEquals(expected, actual)
    }
}