package com.chadmarchand.forgeofhistory.ai

/**
 * Maintains list of executable actions.
 */
class ActionRegistrar {
    private val actionExecutors: MutableCollection<ActionExecutor> = mutableListOf()

    fun register(actionExecutor: ActionExecutor) = actionExecutors.add(actionExecutor)

    fun getAll() = actionExecutors.toList()
}
