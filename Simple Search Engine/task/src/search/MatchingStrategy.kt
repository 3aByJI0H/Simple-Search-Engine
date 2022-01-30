package search

enum class MatchingStrategy {
    ALL {
        override fun findIndices(tokens: List<String>, contentStorage: ContentStorage): Iterable<Int> {
            if (tokens.isEmpty()) {
                return emptyList()
            }
            var resultSet = contentStorage.inverseIndex[tokens.first()] ?: setOf()
            for (index in 1..tokens.lastIndex) {
                val anotherSet = contentStorage.inverseIndex[tokens[index]] ?: setOf()
                resultSet = resultSet.intersect(anotherSet)
            }
            return resultSet
        }
    },
    ANY {
        override fun findIndices(tokens: List<String>, contentStorage: ContentStorage): Iterable<Int> {
            if (tokens.isEmpty()) {
                return emptyList()
            }
            var resultSet = contentStorage.inverseIndex[tokens.first()] ?: setOf()
            for (index in 1..tokens.lastIndex) {
                val anotherSet = contentStorage.inverseIndex[tokens[index]] ?: setOf()
                resultSet = resultSet.union(anotherSet)
            }
            return resultSet
        }
    },
    NONE {
        override fun findIndices(tokens: List<String>, contentStorage: ContentStorage): Iterable<Int> {
            val indicesToExclude = mutableSetOf<Int>()
            tokens.forEach { token -> contentStorage.inverseIndex[token]?.let { indicesToExclude.addAll(it) } }
            return contentStorage.contentByLine.indices
                .filter { i -> !indicesToExclude.contains(i) }
                .asIterable()
        }
    },
    /**/;

    abstract fun findIndices(tokens: List<String>, contentStorage: ContentStorage): Iterable<Int>
}