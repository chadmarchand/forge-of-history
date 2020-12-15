package com.chadmarchand.forgeofnations.clock

import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.event.OnEvent
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class ClockController : KoinComponent {
    private val clockService: ClockService by inject()
    private val eventBus: EventBus by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    @OnEvent(GameDayElapsedEvent::class)
    fun handleTestEvent(event: GameDayElapsedEvent) {
        log.info("Handling test event!")
    }

    fun advanceGameTime() {
        log.info("Advancing game time")
        clockService.advanceGameTime()
        eventBus.publish(GameDayElapsedEvent())
    }
}
