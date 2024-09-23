package com.alexeyyuditsky.test

import org.junit.Test

class MyTest(var str: String)

class Test2 {

    private val myTest = MyTest("hello")

    @Test
    fun test1() {
        myTest.str = "aa"
        println(myTest.str)
    }

    @Test
    fun test2() {
       
        println(myTest.str)
    }

}