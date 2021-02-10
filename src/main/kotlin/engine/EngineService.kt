package com.chadmarchand.forgeofhistory.engine

import com.chadmarchand.forgeofhistory.clock.ClockController
import com.chadmarchand.forgeofhistory.world.Nation
import com.chadmarchand.forgeofhistory.world.NationService
import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class EngineService : KoinComponent {
    private val clockController: ClockController by inject()
    private val nationService: NationService by inject()

    fun executeGameLoop() {
        log.debug("Executing game loop")
        clockController.advanceGameTime()

        // Test that the world module is working
        log.debug("Number of nations: ${nationService.getAll()}")
        if (nationService.getAll().isEmpty()) {
            nationService.add(Nation(Id.DEFAULT_ID, "Canada"))
        }
        log.debug("Number of nations: ${nationService.getAll()}")
    }
}
