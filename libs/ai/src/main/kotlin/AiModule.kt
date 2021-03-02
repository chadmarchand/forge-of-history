package com.chadmarchand.forgeofhistory.ai

import org.koin.dsl.module

val aiModule = module(createdAtStart = true) {
    single { AiSystem() }
    single { BehaviorService() }
    single { ActionRegistrar() }
}
