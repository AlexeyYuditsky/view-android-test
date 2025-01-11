package com.alexeyyuditsky.test.example.other

import org.junit.Assert.*

import org.junit.Test

class Test29 {

    @Test
    fun test_function() {
        val list1 = emptyList<Int>()
        val list2 = listOf(1, 1)
        val list3 = listOf(1)
        val list4 = listOf(1, 2, 3)
        val list5 = listOf(1, 2, 3, 3)
        val list6 = listOf(1, 2, 2, 3)
        val list7 = listOf(1, 1, 2, 1)
        val list8 = listOf(2, 1, 2, 1)
        val list9 = listOf(1, 1, 1, 1)

        val res1 = function(list1)
        val res2 = function(list2)
        val res3 = function(list3)
        val res4 = function(list4)
        val res5 = function(list5)
        val res6 = function(list6)
        val res7 = function(list7)
        val res8 = function(list8)
        val res9 = function(list9)

        assertFalse(res1)
        assertTrue(res2)
        assertFalse(res3)
        assertFalse(res4)
        assertTrue(res5)
        assertTrue(res6)
        assertTrue(res7)
        assertFalse(res8)
        assertTrue(res9)
    }

}