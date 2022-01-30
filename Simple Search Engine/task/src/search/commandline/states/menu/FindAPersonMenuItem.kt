package search.commandline.states.menu

import search.ContentStorage
import search.MatchingStrategy
import search.commandline.CommandLineRunner
import search.commandline.states.SuggestMenuRunnerState

internal class FindAPersonMenuItem(
    private val contentStorage: ContentStorage,
    private val commandLineRunner: CommandLineRunner
) : MenuItem {

    private var wordsToSearchFor: List<String> = listOf()
    private var strategy: MatchingStrategy = MatchingStrategy.ANY

    private val notFound: String = "No matching people found."
    private val selectMessage: String = "Select a matching strategy: ${MatchingStrategy.values().joinToString()}"


    override fun toString() = "Find a person"

    override fun interactWithUser() {
        println(selectMessage)
        strategy = MatchingStrategy.valueOf(readLine()!!)
        println("Enter a name or email to search all suitable people.")
        wordsToSearchFor = readLine()!!.split("\\s+".toRegex())

    }

    override fun execute() {
        val foundLines = contentStorage.search(wordsToSearchFor, strategy)

        commandLineRunner.runnerState = SuggestMenuRunnerState(commandLineRunner)
        println(if (foundLines.isNotEmpty()) foundLines.joinToString("\n") else notFound)
    }
}