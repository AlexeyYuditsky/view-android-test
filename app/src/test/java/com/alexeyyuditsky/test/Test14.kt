package com.alexeyyuditsky.test

import com.alexeyyuditsky.test.test.sum
import org.junit.Assert
import org.junit.Test

class Test14 {
    @Test
    fun test() {
        val a = 2_000_000_000
        val b = 1_000_000_000

        val expected = 3_000_000_000
        val actual = sum(a , b)

        Assert.assertEquals(expected, actual)
    }
}