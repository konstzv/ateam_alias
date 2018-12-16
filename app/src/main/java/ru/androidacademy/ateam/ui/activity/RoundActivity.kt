package ru.androidacademy.ateam.ui.activity

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_round.*
import kotlinx.android.synthetic.main.progress_bar.*


import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.model.game.Round
import ru.androidacademy.ateam.presentation.presenter.GamePresenter
import ru.androidacademy.ateam.presentation.view.GameView


class RoundActivity : MvpAppCompatActivity(), GameView {

    @InjectPresenter
    lateinit var gamePresenter: GamePresenter

    val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragment_round)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round)

        ok_button.setOnClickListener {
            nextWord()
        }
    }


    override fun showRoundEnd(game: Game) {
        val builder = AlertDialog.Builder(this@RoundActivity)
        builder.setPositiveButton("Окей") { dialog, which ->
            gamePresenter.initRound()

        }.setMessage("Раунд закончен. Угадано ${game.currentRound.wordsGuessed}").show()

    }

    override fun showFinishGame(currentGame: Game) {
        val builder = AlertDialog.Builder(this@RoundActivity)
        builder.setPositiveButton("Окей") { _,_ ->
            finish()
        }.setMessage("Победили ${currentGame.getWinner()}").show()
    }

    public fun nextWord() {
        gamePresenter.nextWord()
    }


    override fun showRoundBegin(round: Round) {
        val builder = AlertDialog.Builder(this@RoundActivity)
        builder.setPositiveButton("Окей") { _,_ ->
            gamePresenter.startRound()
        }.setMessage("Ход команды ${round.team.name}," +
                " объясняет ${round.playerExplain.name}," +
                " угадывает ${round.playerAnswer.name}}").show()

    }

    override fun showWord(word: String) {
        word_tv.text = word
//        currentFragment?.let {
//            if (currentFragment  is RoundFragment){
//                (currentFragment as RoundFragment).setWord(word)
//            }
//        }

    }

    override fun showMsg(msg: String) {

    }

    override fun setTimePassed(current: Int, max: Int) {
        timer_progress.progress = (100 / max.toDouble() * current.toDouble()).toInt()
//        timer_progress.progress = (Double(100)/max.toDouble())) * Double(current).toInt()
        timer_text_view.text = (max - current).toString()
    }

    override fun startRound() {
//        showRoundFragment()
    }

    override fun pauseRound() {
    }

    override fun resumeRound() {
    }


    override fun setWordGuessed(wordsGuessed: Int) {
        fragment_round_text_view_words_guessed.text = "Угадано $wordsGuessed"
    }

    override fun setWordsLeft(wordsLeft: Int) {
        fragment_round_text_view_words_left.text = "Осталось $wordsLeft "
//        currentFragment?.let {
//            if (currentFragment  is RoundFragment){
//                (currentFragment as RoundFragment).setWordsLeft(wordsLeft)
//            }
//        }
    }


}
