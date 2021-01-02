package com.chadmarchand.forgeofhistory.koin

import com.chadmarchand.forgeofhistory.clock.clockModule
import com.chadmarchand.forgeofhistory.engine.engineModule
import com.chadmarchand.forgeofhistory.research.researchModule
import com.chadmarchand.kutna.event.EventBus
import org.koin.dsl.module
import org.koin.experimental.builder.single

private val eventModule = module { single<EventBus>() }

internal val koinModules = listOf(
    engineModule,
    clockModule,
    eventModule,
    researchModule
)
