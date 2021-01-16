package com.chadmarchand.forgeofhistory.world

import com.chadmarchand.kutna.persistence.repository.Repository
import com.chadmarchand.kutna.persistence.service.getRepositoryQualifier
import org.koin.dsl.module
import org.koin.experimental.builder.single

private val NATION_REPOSITORY_QUALIFIER = getRepositoryQualifier<Nation>()

val worldModule = module(createdAtStart = true) {
    single<NationService>()
    single(NATION_REPOSITORY_QUALIFIER) {
        Repository(Nation::class)
    }
}
