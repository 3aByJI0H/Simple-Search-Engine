package search.commandline.states.menu

import search.ContentStorage
import search.commandline.CommandLineRunner

object Menu {
    private val contentStorage: ContentStorage = ContentStorage
    private val commandLineRunner: CommandLineRunner = CommandLineRunner

    val menuItems: Map<Int, MenuItem> = mapOf(
        1 to FindAPersonMenuItem(contentStorage, commandLineRunner),
        2 to PrintAllPeopleMenuItem(contentStorage, commandLineRunner),
        0 to ExitMenuItem(commandLineRunner),
    )
}