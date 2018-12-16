package ru.androidacademy.ateam.presentation.presenter

import android.os.CountDownTimer
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidacademy.ateam.di.GameModule
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.model.game.Player
import ru.androidacademy.ateam.model.game.Team
import ru.androidacademy.ateam.presentation.view.GameView
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject

enum class State {
    START, PAUSE, RESUME, END
}

@InjectViewState
class GamePresenter : MvpPresenter<GameView>(), IGamePresenter {

    companion object {
        const val MILLIS_PER_SECOND: Long = 1000
    }


    private var timer: CountDownTimer? = null
    private var currentTime: Int = 0

    lateinit var state: State

    @Inject
    lateinit var currentGame: Game

    val gameScope:Scope = Toothpick.openScopes(
       "GameScope"
    )

    init {
        gameScope.installModules(GameModule())
        Toothpick.inject(this,gameScope)

        val player1 = Player("Оля")
        val player2 = Player("Вавара")
        val player3 = Player("Игнат")
        val player4 = Player("Даша")
        val team1 = Team("Слоники", listOf(player1,player2))
        val team2 = Team("Дилдаки", listOf(player3,player4))
        val words = listOf("test","test3","test4","test5")
        currentGame.teams = listOf(team1,team2)
        currentGame.words = words
        currentGame.timeInSec = 10
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initRound()
    }

    override fun nextWord() {
        currentGame.getNextWord()?.let {
            viewState.showWord(it)
            viewState.setWordsLeft(currentGame.getWordsLeft())
        } ?: run {
            finishGame()
        }
    }
    


    private fun finishGame() {
        viewState.showFinishGame(currentGame)
    }

    fun initRound() {

            val round = currentGame.getNextRound()

            viewState.setWordsLeft(currentGame.getWordsLeft())
            viewState.setWordGuessed(round.wordsGuessed)
            viewState.showWord("")
            viewState.showRoundBegin(round)
//            viewState.setTimePassed(0, 0)

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

            nextWord()

            viewState.setWordGuessed(currentGame.currentRound.wordsGuessed++)

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

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(gameScope)
    }
}