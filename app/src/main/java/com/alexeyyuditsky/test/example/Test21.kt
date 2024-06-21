package com.alexeyyuditsky.test.example

data class Organization(
    val name: String,
    val selectedTextIndexes: Pair<Int, Int> = 0 to 0
)

private fun findMatchIndices(organization: Organization, query: CharSequence): Pair<Int, Int> {
    val name = organization.name
    val index = name.indexOf(query.toString(), ignoreCase = true)

    return if (index != -1) {
        Pair(index, index + query.length)
    } else {
        Pair(0, 0)
    }
}


fun main() {
    val organizations = listOf(
        Organization("ян ян"),
        Organization("ИП янде"),
        Organization("Яндекс маркет"),
        Organization("ИП Яковлев")
    )

    val res = organizations.map { findMatchIndices(it, "мар") }
    println(res)

    // [(0, 5), (0, 0), (0, 0), (0, 0)]
}