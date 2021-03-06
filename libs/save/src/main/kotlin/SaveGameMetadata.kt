package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import com.chadmarchand.kutna.persistence.field.Persist
import com.chadmarchand.kutna.persistence.field.PrimaryId

@DynamicEntity
data class SaveGameMetadata(
    @Persist
    @PrimaryId
    var id: Id = Id.DEFAULT_ID,

    @Persist
    var fieldName: String = "",

    @Persist
    var fieldValue: String? = null
)
