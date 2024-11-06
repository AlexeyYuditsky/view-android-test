package com.alexeyyuditsky.test.example.other

enum class AppVersionState(
    private val value: String
) {
    LOADING("Обновление скачивается"),
    RELEVANT("Установлена актуальная версия"),
    IRRELEVANT("Новая версия готова к установке");

    companion object {
        fun fromValue(value: String): AppVersionState {
            return entries.find { it.value == value }
                ?: throw IllegalArgumentException("Unknown value: $value")
        }
    }
}

fun main() {
    val name = "Установлена актуальная версия"
    val res = AppVersionState.fromValue(name)
    println(res)
}

abstract class AAA {
    data object S: AAA()
}
