package search

import search.commandline.CommandLineRunner
import search.init.Context


fun main(args: Array<String>) {
    val builder = ProgramInitializer(Context)
    builder.initialize(args)
    CommandLineRunner.run()
}
