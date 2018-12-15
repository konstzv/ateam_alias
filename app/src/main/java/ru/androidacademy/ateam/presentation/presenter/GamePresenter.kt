package ru.androidacademy.ateam.presentation.presenter

import android.os.CountDownTimer
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.presentation.view.GameView

enum class State {
    START, PAUSE, RESUME, END
}

@InjectViewState
class GamePresenter : MvpPresenter<GameView>(), IGamePresenter {

    companion object {
        const val MILLIS_PER_SECOND: Long = 1000
    }

    lateinit var currentGame: Game
    
    private var timer: CountDownTimer? = null
    private var currentTime: Int = 0

    lateinit var state: State

    override fun nextWord() {
        currentGame.getNextWord()?.let {
            viewState.showWord(it)
            viewState.setWordsLeft(currentGame.getWordsLeft())
        } ?: run {
            endRound()
        }
    }
    
    fun setGame(game: Game) {
        currentGame = game
    }

    private fun finishGame() {
        viewState.showFinishGame(currentGame)
    }

    fun initRound() {
        if (currentGame.getWordsLeft() == 0) {
            finishGame()
        } else {
            val round = currentGame.getNextRound()
            viewState.showRoundBegin(round)
            viewState.setWordsLeft(currentGame.getWordsLeft())
            viewState.setWordGuessed(round.wordsGuessed)
            viewState.showWord("")
            viewState.setTimePassed(0, 0)
        }
    }

    fun startRound() {
        state = State.START

        viewState.startRound()
        nextWord()

        currentTime = currentGame.timeInSec
        startTimer()
    }

    fun pauseRound() {
        state = State.PAUSE

        viewState.pauseRound()

        stopTimer()
    }

    fun resumeRound() {
        state = State.RESUME

        viewState.resumeRound()

        startTimer()
    }

    private fun endRound() {
        state = State.END

        viewState.showRoundEnd(currentGame)
        currentGame.currentRound.run {
            team.score = team.score + wordsGuessed
        }

        stopTimer()
    }

    

    fun skip() {
        if (currentGame.currentRound.skipNum != 0) {
            nextWord()
        } else {

        }
    }

    fun guess() {
        if (currentGame.currentRound.skipNum != 0) {
            nextWord()

            viewState.setWordGuessed(currentGame.currentRound.wordsGuessed++)
        } else {

        }
    }

    fun changeState() {
        when (state) {
            State.PAUSE -> resumeRound()
            else -> pauseRound()
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(currentTime * MILLIS_PER_SECOND,
            MILLIS_PER_SECOND
        ) {
            override fun onTick(millisUntilFinished: Long) {
                currentTime = (millisUntilFinished / MILLIS_PER_SECOND).toInt()
                val passedTime: Int = currentGame.timeInSec - currentTime
                viewState.setTimePassed(passedTime, currentGame.timeInSec)
            }

            override fun onFinish() {
                viewState.showRoundEnd(currentGame)
            }
        }.start()
    }

    private fun stopTimer() {
        timer?.cancel()
    }
}