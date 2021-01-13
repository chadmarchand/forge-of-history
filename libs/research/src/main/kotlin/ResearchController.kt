package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.clock.GameDayElapsedEvent
import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.event.OnEvent
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class ResearchController : KoinComponent {
    private val eventBus: EventBus by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    @OnEvent(GameDayElapsedEvent::class)
    fun handleGameDayElapsedEvent(event: GameDayElapsedEvent) {
        log.info("Handled GameDayElapsedEvent")
    }
}
