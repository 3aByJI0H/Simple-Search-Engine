package search

import search.commandline.states.ContentFillingRunnerState
import search.init.Context
import search.init.DataFillingStep

class ProgramInitializer(private val context: Context) {

    private companion object Flags {
        const val DATA = "--data"
    }

    fun initialize(args: Array<String>) {
        if (args.isEmpty()) {
            context.commandLineRunner.runnerState = ContentFillingRunnerState(
                context.contentStorage, context.commandLineRunner
            )
            return
        }
        processArgs(args.iterator())
    }

    private fun processArgs(argsIterator: Iterator<String>) {
        while (argsIterator.hasNext()) {
            val step = when (val currentArg = argsIterator.next()) {
                DATA -> DataFillingStep(context)
                else -> throw IllegalArgumentException("Invalid argument $currentArg")
            }
            step.process(argsIterator)
        }
    }
}