package search.commandline

import search.commandline.states.ContentFillingRunnerState
import search.commandline.states.RunnerState
import search.commandline.states.TerminalState

object CommandLineRunner {
    var runnerState: RunnerState = TerminalState()

    fun run() {
        while (runnerState !is TerminalState) {
            if (runnerState !is ContentFillingRunnerState) {
                println()
            }
            runnerState.interactWithUser()
            runnerState.execute()
        }
    }
}