package search.commandline.states.menu

import search.ContentStorage
import search.commandline.CommandLineRunner
import search.commandline.states.SuggestMenuRunnerState

internal class PrintAllPeopleMenuItem(
    private val contentStorage: ContentStorage,
    private val commandLineRunner: CommandLineRunner
) : MenuItem {

    override fun toString() = "Print all people"

    override fun interactWithUser() {

    }

    override fun execute() {
        println("=== List of people ===")
        println(contentStorage.contentByLine.joinToString("\n"))
        commandLineRunner.runnerState = SuggestMenuRunnerState(commandLineRunner)
    }
}