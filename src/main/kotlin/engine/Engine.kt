package com.chadmarchand.forgeofnations.engine

import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class Engine : KoinComponent {
    private val engineService: EngineService by inject()

    fun initialize() {
        log.info("Initializing engine")
        engineService.doSomething()
    }
}
