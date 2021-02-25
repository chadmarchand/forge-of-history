package com.chadmarchand.forgeofhistory.component

import com.artemis.World
import com.chadmarchand.forgeofhistory.world.StockpileComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ComponentSystemAdapter : KoinComponent {
    private val world: World by inject()

    fun initialize() {
        // Temporarily add entities for testing purposes
        val entityId = world.create()
        world.edit(entityId).create(StockpileComponent::class.java).money = 2000.0

        val entityId2 = world.create()
        world.edit(entityId2).create(StockpileComponent::class.java).money = 3000.0
    }

    fun loop() {
        world.process()
    }
}
