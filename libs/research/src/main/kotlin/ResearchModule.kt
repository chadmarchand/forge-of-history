package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.kutna.persistence.repository.Repository
import com.chadmarchand.kutna.persistence.service.getRepositoryQualifier
import org.koin.dsl.module
import org.koin.experimental.builder.single

private val TECHNOLOGY_REPOSITORY_QUALIFIER = getRepositoryQualifier<Technology>()

val researchModule = module(createdAtStart = true) {
    single<ResearchController>()

    single<TechnologyService>()
    single(TECHNOLOGY_REPOSITORY_QUALIFIER) {
        Repository(Technology::class)
    }
}
