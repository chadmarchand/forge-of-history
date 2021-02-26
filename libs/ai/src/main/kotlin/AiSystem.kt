package com.chadmarchand.forgeofhistory.ai

import com.artemis.annotations.All
import com.artemis.systems.IteratingSystem
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val logger = KotlinLogging.logger {}

@All(AiControllerComponent::class)
class AiSystem : IteratingSystem(), KoinComponent {
    private val behaviorService: BehaviorService by inject()

    override fun process(id: Int) {
        logger.debug("Processing AI controller component with ID: $id")
        behaviorService.process(id)
    }
}
