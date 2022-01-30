package search.commandline.states

import search.ContentStorage
import search.commandline.CommandLineRunner

class ContentFillingRunnerState(
    private val contentStorage: ContentStorage,
    private val commandLineRunner: CommandLineRunner
) : RunnerState {

    override fun interactWithUser() {
        println("Enter the number of people:")
        val peopleNumber = readLine()!!.toInt()
        println("Enter all people:")
        contentStorage.contentByLine = List(peopleNumber) { readLine()!!.trim() }
    }

    override fun execute() {
        commandLineRunner.runnerState = SuggestMenuRunnerState(commandLineRunner)
    }
}