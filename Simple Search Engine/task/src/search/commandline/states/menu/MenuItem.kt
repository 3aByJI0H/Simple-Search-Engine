package search.commandline.states.menu

import search.commandline.states.RunnerState

interface MenuItem : RunnerState {

    override fun toString(): String
}