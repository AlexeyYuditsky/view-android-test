package com.alexeyyuditsky.test.example.other

interface DeepCloneable<T> {
    fun deepClone(): T
}

class MyUser(
    private val id: Long,
    private val name: MyUserName
) : DeepCloneable<MyUser> {
    override fun deepClone(): MyUser {
        return MyUser(id, name.deepClone())
    }
}

class MyUserName(
    private val firstName: String,
    private val lastName: String
) : DeepCloneable<MyUserName> {
    override fun deepClone(): MyUserName {
        return MyUserName(firstName, lastName)
    }
}

fun main() {
    val original = MyUser(1, MyUserName("Alex", "Ivanov"))
    val deepCopy = original.deepClone()
}