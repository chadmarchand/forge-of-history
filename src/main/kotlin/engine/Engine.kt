package com.chadmarchand.forgeofnations.engine

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Engine : KoinComponent {
    private val engineService: EngineService by inject()

    fun initialize() {
        println("Initializing engine")
        engineService.doSomething()
    }
}
