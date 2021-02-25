package com.chadmarchand.forgeofhistory.component

import com.chadmarchand.forgeofhistory.world.EconomySystem
import com.artemis.World
import com.artemis.WorldConfigurationBuilder

internal fun createArtemisWorld(): World {
    val config = WorldConfigurationBuilder()
        .with(
            EconomySystem()
        ).build()
    return World(config)
}
