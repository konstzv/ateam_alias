package ru.androidacademy.ateam.ui.activity


import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment

import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_round.*
import kotlinx.android.synthetic.main.progress_bar.*
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.Game
import ru.androidacademy.ateam.model.Round
import ru.androidacademy.ateam.presentation.presenter.GamePresenter
import ru.androidacademy.ateam.presentation.view.GameView
import ru.androidacademy.ateam.ui.fragment.GameFinishFragment
import ru.androidacademy.ateam.ui.fragment.RoundBeginFragment
import ru.androidacademy.ateam.ui.fragment.RoundEndFragment
import java.util.*


class RoundActivity : MvpAppCompatActivity(), GameView {
    override fun showSkips(skipNum: Int) {
        fragment_round_text_view_skips.text = "Пропусков осталось ${skipNum.toString()}"
    }


    @InjectPresenter
    lateinit var gamePresenter: GamePresenter

    val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragment_round)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round)
        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle(R.string.bar_game_started)

        ok_button.setOnClickListener {
            gamePresenter.guess()
        }
        skip_button.setOnClickListener {
            gamePresenter.skip()
        }
    }


    override fun showRoundEnd(game: Game) {
        supportFragmentManager.beginTransaction().add(R.id.fragment_round, RoundEndFragment())
            .addToBackStack(null).commit()
    }

    override fun showFinishGame(currentGame: Game) {
        supportFragmentManager.beginTransaction().add(R.id.fragment_round, GameFinishFragment())
            .commit()
//        val builder = AlertDialog.Builder(this@RoundActivity)
//        builder.setPositiveButton("Окей") { _,_ ->
//            finish()
//        }.setMessage("Победили ${currentGame.getWinner()}").show()
    }


    override fun showRoundBegin(round: Round) {
//        val builder = AlertDialog.Builder(this@RoundActivity)
//        builder.setPositiveButton("Окей") { _,_ ->
//
//        }.setMessage("Ход команды ${round.team.name}," +
//                " объясняет ${round.playerExplain.name}," +
//                " угадывает ${round.playerAnswer.name}}").show()
        supportFragmentManager.beginTransaction().add(R.id.fragment_round, RoundBeginFragment())
            .addToBackStack(null).commit()


    }


    override fun showWord(word: String) {
        word_tv.text = word
//        currentFragment?.let {
//            if (currentFragment  is RoundFragment){
//                (currentFragment as RoundFragment).setWord(text)
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

    fun onRoundBeginClick() {
        onBackPressed()
        gamePresenter.startRound()
    }

    fun onRoundEndClick() {
        onBackPressed()
        gamePresenter.initRound()
    }

    fun onGameFinished() {
        finish()
    }


}
