package ru.androidacademy.ateam.model

import kotlin.random.Random


data class Team(val name: String, val players: List<Player>, var score: Int = 0) {

    var index: Int = 0
    lateinit var currentPlayer: Player

//    init {
//        index = Random.nextInt(0, players.size)
//        getNextPlayer()
//    }

    fun getNextPlayer(): Player {
        val player = players[nextIndex()]
        currentPlayer = player
        return player
    }

    private fun nextIndex(): Int {
        if (index >= players.size - 1) {
            index = 0
            return index
        } else {
            index += 1
            return index
        }
    }
}