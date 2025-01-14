package com.alexeyyuditsky.test.example.task

import org.junit.Assert.*
import org.junit.Test

class Test2 {

    @Test
    fun test_valid() {
        val input1 = ""
        val input2 = "()"
        val input3 = "[]"
        val input4 = "{}"
        val input5 = "{}]"
        val input6 = "[{}"
        val input7 = "[{}}"
        val input8 = "[{})"
        val input9 = "["
        val input10 = "]"
        val input11 = "{[()]}"
        val input12 = "{[()]"

        val output1 = isValid(input1)
        val output2 = isValid(input2)
        val output3 = isValid(input3)
        val output4 = isValid(input4)
        val output5 = isValid(input5)
        val output6 = isValid(input6)
        val output7 = isValid(input7)
        val output8 = isValid(input8)
        val output9 = isValid(input9)
        val output10 = isValid(input10)
        val output11 = isValid(input11)
        val output12 = isValid(input12)

        assertFalse(output1)
        assertTrue(output2)
        assertTrue(output3)
        assertTrue(output4)
        assertFalse(output5)
        assertFalse(output6)
        assertFalse(output7)
        assertFalse(output8)
        assertFalse(output9)
        assertFalse(output10)
        assertTrue(output11)
        assertFalse(output12)
    }

}