package com.chadmarchand.forgeofnations.clock

class ClockStore {
    private var gameTime = 1

    fun setGameTime(gameTime: Int) {
        this.gameTime = gameTime
    }

    fun getGameTime(): Int = gameTime
}
