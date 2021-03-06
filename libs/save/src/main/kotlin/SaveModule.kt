package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.persistence.repository.Repository
import com.chadmarchand.kutna.persistence.service.getRepositoryQualifier
import org.koin.dsl.module
import org.koin.experimental.builder.single

val saveModule = module(createdAtStart = true) {
    single { SaveGameService() }

    single<SaveGameMetadataService>()
    single(getRepositoryQualifier<SaveGameMetadata>()) {
        Repository(SaveGameMetadata::class)
    }
}
