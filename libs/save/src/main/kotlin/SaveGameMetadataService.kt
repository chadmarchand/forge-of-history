package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.persistence.service.PersistentService
import java.util.*

const val COMPONENT_STATE_METADATA_FIELD = "ComponentState"

class SaveGameMetadataService : PersistentService<SaveGameMetadata>() {
    fun getMetadataField(fieldName: String): Optional<SaveGameMetadata> {
        return this.getFirst(mapOf(Pair(SaveGameMetadata::fieldName.name, fieldName)))
    }

    fun setMetadataField(fieldName: String, value: String) {
        val existingMetadataField = getMetadataField(fieldName).orElse(null)
        val metaDataField = existingMetadataField ?: SaveGameMetadata(
            fieldName = fieldName,
            fieldValue = value
        )
        if (existingMetadataField != null) {
            this.update(metaDataField)
        } else {
            this.add(metaDataField)
        }
    }
}
