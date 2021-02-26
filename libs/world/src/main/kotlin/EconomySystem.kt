package com.chadmarchand.forgeofhistory.world

import com.artemis.ComponentMapper
import com.artemis.annotations.All
import com.artemis.systems.IteratingSystem
import com.chadmarchand.forgeofhistory.clock.GameDayElapsedEvent
import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.event.OnEvent
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private val logger = KotlinLogging.logger {}

@All(StockpileComponent::class)
class EconomySystem : IteratingSystem(), KoinComponent {
    private val eventBus: EventBus by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    private lateinit var stockpileComponentMap: ComponentMapper<StockpileComponent>

    override fun process(id: Int) {
        logger.debug("Processing stockpile component with money: ${stockpileComponentMap[id].money}")
    }

    @OnEvent(GameDayElapsedEvent::class)
    fun handleGameDayElapsedEvent(event: GameDayElapsedEvent) {
        logger.debug("Handling GameDayElapsedEvent for ${this.entityIds.size()} entities")
        for (i in 0 until this.entityIds.size()) {
            stockpileComponentMap[this.entityIds.get(i)].money += 500.0
            logger.debug("Stockpile money amount: ${stockpileComponentMap[this.entityIds.get(i)].money}")
        }
    }
}
