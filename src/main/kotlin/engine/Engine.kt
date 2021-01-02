package com.chadmarchand.forgeofhistory.engine

import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}
private val NUM_LOOPS = 10 // temporary until proper lifecycle implemented

class Engine : KoinComponent {
    private val engineService: EngineService by inject()

    fun initialize() {
        log.info("Initializing engine")

        var loops = 0
        while (loops < NUM_LOOPS) {
            engineService.executeGameLoop()
            loops += 1
        }
    }
}
