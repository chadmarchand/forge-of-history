package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.kutna.persistence.repository.Repository
import com.chadmarchand.kutna.persistence.service.getRepositoryQualifier
import org.koin.dsl.module
import org.koin.experimental.builder.single

val researchModule = module(createdAtStart = true) {
    single<ResearchController>()

    single<TechnologyService>()
    single(getRepositoryQualifier<Technology>()) {
        Repository(Technology::class)
    }

    single<ResearchProjectService>()
    single(getRepositoryQualifier<ResearchProject>()) {
        Repository(ResearchProject::class)
    }

    single { QueueResearchActionExecutor() }
}
