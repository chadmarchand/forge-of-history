package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.event.Event

/**
 * Event that triggers systems to load the game using the database that has already been loaded.
 */
class LoadGameEvent : Event(
    LoadGameEvent::class.qualifiedName!!
)
