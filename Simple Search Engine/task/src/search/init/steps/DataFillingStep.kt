package search.init

import search.commandline.states.SuggestMenuRunnerState
import java.io.File

class DataFillingStep(private val context: Context) : InitStep {

    override fun process(argsIterator: Iterator<String>) {
        if (!argsIterator.hasNext()) {
            throw IllegalArgumentException("File path is required")
        }
        val file = File(argsIterator.next())
        if (!file.isFile) {
            throw IllegalArgumentException("File path is required")
        }
        context.contentStorage.contentByLine = file.readLines()
        context.commandLineRunner.runnerState = SuggestMenuRunnerState(context.commandLineRunner)
    }
}