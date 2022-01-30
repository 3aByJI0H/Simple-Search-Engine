package search.commandline.states

import search.commandline.CommandLineRunner
import search.commandline.states.menu.Menu
import search.commandline.states.menu.MenuItem

class SuggestMenuRunnerState(private val commandLineRunner: CommandLineRunner) : RunnerState {
    private var chosenMenuItem: MenuItem? = null
    private val menu: Menu = Menu

    override fun interactWithUser() {
        println("=== Menu ===")
        menu.menuItems.forEach { (index, menuItem) -> println("$index. $menuItem") }
        val menuItemNumber = readLine()!!.toInt()
        chosenMenuItem = Menu.menuItems[menuItemNumber]
    }

    override fun execute() {
        chosenMenuItem?.also { commandLineRunner.runnerState = it }
            ?: println("\nIncorrect option! Try again.")
    }
}