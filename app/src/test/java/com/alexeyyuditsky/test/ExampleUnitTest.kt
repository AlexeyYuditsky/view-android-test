package com.alexeyyuditsky.test

import com.alexeyyuditsky.test.test.A
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

interface A {
    fun sum(a: Int, b: Int): Int
}


class ExampleUnitTest {
    @Test(expected = IllegalArgumentException::class)
    fun checkSumIllegalArgumentException() {
        val a = object : A {
            override fun sum(a: Int, b: Int): Int {
                throw IllegalArgumentException()
            }
        }
        a.sum(1500000000, 1500000000)
    }

    @Test
    fun checkSumRight() {
        val a = object : A {
            override fun sum(a: Int, b: Int): Int {
                return a + b
            }
        }

        val actual = a.sum(1, 1)
        val expected = 2

        assertEquals(expected, actual)
    }
}