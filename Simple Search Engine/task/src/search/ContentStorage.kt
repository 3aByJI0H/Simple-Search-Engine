package search

import java.util.*

object ContentStorage {

    var contentByLine: List<String> = listOf()
        set(value) {
            field = value
            inverseIndex = createInverseIndex(field)
        }

    var inverseIndex: Map<String, SortedSet<Int>> = mapOf()
        private set

    fun search(words: List<String>, strategy: MatchingStrategy): List<String> {
        val indexesFound = strategy.findIndices(words, this)
        return contentByLine.slice(indexesFound.toSortedSet())
    }

    private fun createInverseIndex(lines: List<String>): Map<String, SortedSet<Int>> {
        val indexMap = mutableMapOf<String, MutableSet<Int>>()
        lines.asSequence()
            .forEachIndexed { index: Int, line: String ->
                line.splitToSequence("\\s+".toRegex())
                    .forEach { word ->
                        indexMap.getOrPut(word.lowercase()) { mutableSetOf() }.add(index)
                    }
            }
        return indexMap.asSequence()
            .map { (word, indexes) -> word to indexes.toSortedSet() }
            .toMap()
    }
}