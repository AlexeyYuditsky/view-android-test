package com.alexeyyuditsky.test.test

data class Organization(
    val name: String,
    val selectedTextIndexes: Pair<Int, Int> = 0 to 0
)

fun findMatchIndices(text: String, query: String): Pair<Int, Int> {
    var currentIndex = 0

    text.split(" ").forEach { word ->
        // Проверяем, если слово начинается с query
        if (word.startsWith(query, true)) {
            val startIndex = currentIndex
            val endIndex = currentIndex + query.length - 1
            return Pair(startIndex, endIndex)
        }
        // Обновляем текущий индекс для следующего слова
        currentIndex += word.length + 1 // +1 для учета пробела между словами
    }

    return Pair(0, 0)
}

fun main() {
    val organizations =
        listOf(Organization("ип иванов"), Organization("ИП янде"), Organization("Яндекс маркет"), Organization("мар янд"))

    val result = organizations.map {
        val selectedTextIndexes = findMatchIndices(it.name, "янд")
        if (selectedTextIndexes == Pair(0, 0)) it
        else it.copy(selectedTextIndexes = selectedTextIndexes)
    }

    val nonZeroSecond = result.filter { it.selectedTextIndexes.second != 0 }.sortedBy { it.selectedTextIndexes.first }
    val zeroSecond = result.filter { it.selectedTextIndexes.second == 0 }

    // Объединяем отфильтрованные и отсортированные списки
    val result2 = nonZeroSecond + zeroSecond

    println(result2.map { it.selectedTextIndexes })
}