package search.init

interface InitStep {

    fun process(argsIterator: Iterator<String>)
}