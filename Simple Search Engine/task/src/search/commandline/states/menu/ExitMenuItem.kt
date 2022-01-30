package search.commandline.states.menu

import search.commandline.CommandLineRunner
import search.commandline.states.TerminalState

internal class ExitMenuItem(private val commandLineRunner: CommandLineRunner) : MenuItem {

    override fun toString() = "Exit"

    override fun interactWithUser() {

    }

    override fun execute() {
        commandLineRunner.runnerState = TerminalState()
        println("Bye!")
    }
}