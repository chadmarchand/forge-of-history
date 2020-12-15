package com.chadmarchand.forgeofnations.clock

import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class ClockService : KoinComponent {
    private val store: ClockStore by inject()

    fun advanceGameTime() {
        var currentGameTime = store.getGameTime()
        currentGameTime += 1
        log.trace("Setting game time to $currentGameTime")
        store.setGameTime(currentGameTime)
    }
}
