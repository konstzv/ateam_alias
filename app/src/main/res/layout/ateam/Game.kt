package ru.androidacademy.ateam

import kotlin.random.Random

data class Game(val timeInSec: Int, val words: List<String>, var teams: List<Team>, var rounds:List<Round>?) {
    private var currentWordIndex: Int = 0
    private var currentTeamIndex: Int
     lateinit var currentRound: Round


    init {
        currentTeamIndex = Random.nextInt(0, teams.size)
    }

    fun getWordsLeft(): Int {
        return words.size - 1 - currentWordIndex
    }

    fun getNextTeam(): Team {
        return teams[nextIndex()]
    }

    private fun nextIndex(): Int {
        if (currentTeamIndex >= teams.size - 1) {
            currentTeamIndex = 0
            return currentTeamIndex
        } else {
            currentTeamIndex += 1
            return currentTeamIndex
        }
    }

    fun getNextRound(): Round {
        val team = getNextTeam()
        currentRound = Round(team, team.getNextPlayer(), team.getNextPlayer())
        return currentRound
    }

    fun getNextWord(): String? {
        if (currentWordIndex < words.size - 1) {
            return words[currentWordIndex++]
        }else{
            return null
        }
    }

    fun getWinner():Team?{
       return teams.maxBy { it.score }
    }
}