package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.clock.GameDayElapsedEvent
import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.event.OnEvent
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val log = KotlinLogging.logger {}

class ResearchController : KoinComponent {
    private val eventBus: EventBus by inject()
    private val technologyService: TechnologyService by inject()
    private val researchProjectService: ResearchProjectService by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    fun getTechnologies(): List<Technology> {
        return technologyService.getAll()
    }

    fun addTechnology(technology: Technology): Technology {
        return technologyService.add(technology)
    }

    fun queueResearchProject(technologyId: Id, entityId: Int): ResearchProject {
        return researchProjectService.add(ResearchProject(technologyId = technologyId, entityId = entityId))
    }

    fun getResearchProjects() = researchProjectService.getAll()

    @OnEvent(GameDayElapsedEvent::class)
    fun handleGameDayElapsedEvent(event: GameDayElapsedEvent) {
        log.info("Handled GameDayElapsedEvent")
        if (getTechnologies().isEmpty()) {
            technologyService.add(Technology(Id.DEFAULT_ID, "Tech 1"))
        }
    }
}
