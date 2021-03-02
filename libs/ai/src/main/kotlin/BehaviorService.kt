package com.chadmarchand.forgeofhistory.ai

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BehaviorService : KoinComponent {
    private val actionRegistrar: ActionRegistrar by inject()

    fun process(entityId: Int) {
        actionRegistrar.getAll().first().execute(entityId)
    }
}
