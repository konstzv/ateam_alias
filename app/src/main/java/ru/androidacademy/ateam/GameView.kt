package ru.androidacademy.ateam

import com.arellomobile.mvp.MvpView


interface GameView:MvpView{
    fun showRoundBegin(round: Round)
    fun showWord(word:String)

    fun showMsg(msg:String)

    fun setTimePassed(current: Int, max: Int)

    fun startRound()
    fun pauseRound()
    fun resumeRound()

    fun showRoundEnd(game: Game)

    fun setWordGuessed(wordsGuessed: Int)
    fun setWordsLeft(wordsLeft: Int)
    fun showFinishGame(currentGame: Game)
}