package com.chadmarchand.forgeofnations.research

import org.koin.dsl.module
import org.koin.experimental.builder.single

val researchModule = module(createdAtStart = true) {
    single<ResearchController>()
}
