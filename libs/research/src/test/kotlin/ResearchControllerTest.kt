package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.world.Nation
import com.chadmarchand.forgeofhistory.world.NationService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.core.component.inject
import org.koin.test.KoinTest

@ExtendWith(ResearchTestExtension::class)
class ResearchControllerTest : KoinTest {
    private val researchController: ResearchController by inject()

    @Test
    fun canBeCreatedFromKoin() {
        assertThat(researchController).isNotNull
    }

    @Test
    fun canAddAndGetTechnologies() {
        assertThat(researchController.getTechnologies()).isEmpty()
        researchController.addTechnology(Technology(name = "Tech 1"))
        assertThat(researchController.getTechnologies().isNotEmpty())
    }

    @Test
    fun canQueueResearchProject() {
        assertThat(researchController.getResearchProjects()).isEmpty()

        val entityId = 2
        val tech = researchController.addTechnology(Technology(name = "Tech 1"))

        researchController.queueResearchProject(tech.id, entityId)

        assertThat(researchController.getResearchProjects()).isNotEmpty()
    }
}
