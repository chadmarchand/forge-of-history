package com.chadmarchand.forgeofhistory.ai

import com.chadmarchand.forgeofhistory.research.ResearchController
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BehaviorService : KoinComponent {
    private val researchController: ResearchController by inject()

    fun process(entityId: Int) {
        // For now, just queue research project if there are none queued
        // The dependency relationship should eventually be reversed, such that the research
        // module depends on the ai module and not vice-versa.
        if (researchController.getResearchProjects().filter { it.entityId == entityId }.isEmpty()) {
            researchController.queueResearchProject(1L, entityId)
        }
    }
}
