package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.ai.ActionExecutor
import com.chadmarchand.forgeofhistory.ai.ActionRegistrar
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val logger = KotlinLogging.logger {}

class QueueResearchActionExecutor : ActionExecutor, KoinComponent {
    private val actionRegistrar: ActionRegistrar by inject()

    init {
        actionRegistrar.register(this)
    }

    override fun execute(entityId: Int): Unit {
        logger.debug("Queueing research project with entityID: $entityId")
    }
}
