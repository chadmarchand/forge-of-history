package com.chadmarchand.forgeofnations.koin

import com.chadmarchand.forgeofnations.clock.clockModule
import com.chadmarchand.forgeofnations.engine.engineModule

internal val koinModules = listOf(
    engineModule,
    clockModule
)
