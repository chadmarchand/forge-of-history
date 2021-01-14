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
    private val technologyService: TechnologyService by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    fun getTechnologies(): List<Technology> {
        return technologyService.getAll()
    }

    fun addTechnology(technology: Technology): Technology {
        return technologyService.add(technology)
    }

    @OnEvent(GameDayElapsedEvent::class)
    fun handleGameDayElapsedEvent(event: GameDayElapsedEvent) {
        log.info("Handled GameDayElapsedEvent")
        if (getTechnologies().isEmpty()) {
            technologyService.add(Technology(null, "Tech 1"))
        }
    }
}
