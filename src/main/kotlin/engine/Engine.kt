package com.chadmarchand.forgeofhistory.engine

import com.chadmarchand.forgeofhistory.component.ComponentSystemAdapter
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}
private const val NUM_LOOPS = 10 // temporary until proper lifecycle implemented

class Engine : KoinComponent {
    private val engineService: EngineService by inject()
    private val componentSystem: ComponentSystemAdapter by inject()

    fun initialize() {
        log.info("Initializing engine")

        componentSystem.initialize()

        var loops = 0
        while (loops < NUM_LOOPS) {
            engineService.executeGameLoop()
            componentSystem.loop()
            loops += 1
        }
    }
}
