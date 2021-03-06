package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.event.Event

/**
 * Event used to trigger anything that doesn't normally keep the database updated to save its data
 * to the database before the database gets saved to file.
 */
class SaveGameEvent : Event(
    SaveGameEvent::class.qualifiedName!!
)
