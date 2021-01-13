package com.chadmarchand.forgeofhistory.research

import org.koin.dsl.module
import org.koin.experimental.builder.single

val researchModule = module(createdAtStart = true) {
    single<ResearchController>()
}
