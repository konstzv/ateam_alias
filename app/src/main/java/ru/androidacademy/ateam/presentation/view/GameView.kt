package ru.androidacademy.ateam.presentation.view

import com.arellomobile.mvp.MvpView
import ru.androidacademy.ateam.model.Game
import ru.androidacademy.ateam.model.Round


interface GameView : MvpView {
    fun showRoundBegin(round: Round)
    fun showWord(word: String)

    fun showMsg(msg: String)

    fun setTimePassed(current: Int, max: Int)

    fun startRound()
    fun pauseRound()
    fun resumeRound()

    fun showRoundEnd(game: Game)

    fun setWordGuessed(wordsGuessed: Int)
    fun setWordsLeft(wordsLeft: Int)
    fun showFinishGame(currentGame: Game)
    fun showSkips(skipNum: Int)

}