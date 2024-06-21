package com.alexeyyuditsky.test.example

val regexPattern =
    "^(" +
            "\\d{3}-A\\d{6}-\\d{9}" +
            "|\\d{3}-\\d{7}-\\d{9}" +
            "|\\d{3}-\\d{5}\\s{2}-\\d{9}" +
            "|\\d{21}" +
            "|CID-\\d{16}" +
            "|SH\\d{19}" +
            "|LM\\d{19}" +
            "|\\d{3}-AB-\\d{10}" +
            "|\\d{3}-\\d{5}-\\d{11}" +
            "|ZXC\\d{18}" +
            "|\\d{3}-IN\\d{15}" +
            "|\\d{3}-\\d{6}\\s-\\d{9}" +
            ")$"

fun main() {
    val patterns = listOf(
        "111-A111111-111111111",
        "111-1111111-111111111",
        "111-11111  -111111111",
        "111111111111111111111",
        "CID-1111111111111111",
        "SH1111111111111111111",
        "LM1111111111111111111",
        "111-Ab-1111111111",
        "111-11111-11111111111",
        "ZXC111111111111111111",
        "111-IN111111111111111",
        "111-111111 -111111111"
    )

    val regex = regexPattern.toRegex()

    patterns.forEach { pattern ->
        println("$pattern matches: ${regex.matches(pattern)}")
    }
}