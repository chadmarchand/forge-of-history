package com.chadmarchand.forgeofhistory.engine

import com.chadmarchand.forgeofhistory.clock.ClockController
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class EngineService : KoinComponent {
    private val clockController: ClockController by inject()

    fun executeGameLoop() {
        log.debug("Executing game loop")
        clockController.advanceGameTime()
    }
}
