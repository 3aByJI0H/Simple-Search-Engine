package search.init

import search.ContentStorage
import search.commandline.CommandLineRunner

object Context {
    internal val commandLineRunner: CommandLineRunner = CommandLineRunner
    internal val contentStorage: ContentStorage = ContentStorage
}