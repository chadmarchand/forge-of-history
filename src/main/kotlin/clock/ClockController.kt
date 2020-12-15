package com.chadmarchand.forgeofnations.clock

import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class ClockController : KoinComponent {
    private val clockService: ClockService by inject()

    fun advanceGameTime() {
        log.info("Advancing game time")
        clockService.advanceGameTime()
    }
}
