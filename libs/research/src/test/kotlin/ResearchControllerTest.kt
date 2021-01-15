package com.chadmarchand.forgeofhistory.research

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
        researchController.addTechnology(Technology(null, "Tech 1"))
        assertThat(researchController.getTechnologies().isNotEmpty())
    }
}
