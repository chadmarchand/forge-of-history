package com.chadmarchand.forgeofhistory.world

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.core.component.inject
import org.koin.test.KoinTest

@ExtendWith(WorldTestExtension::class)
class NationServiceTest : KoinTest {
    private val nationService: NationService by inject()

    @Test
    fun canBeCreatedFromKoin() {
        assertThat(nationService).isNotNull
    }

    @Test
    fun canAddAndGetNation() {
        assertThat(nationService.getAll()).isEmpty()
        nationService.add(Nation(null, "Canada"))
        assertThat(nationService.getAll().isNotEmpty())
    }
}
