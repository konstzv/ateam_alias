package ru.androidacademy.ateam.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.androidacademy.ateam.ui.fragment.RoundFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.androidacademy.ateam.*


class RoundActivity : MvpAppCompatActivity(), GameView {

    @InjectPresenter
    lateinit var gamePresenter: GamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round)

        runFragmentRound()
    }

    fun runFragmentRound() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_round, RoundFragment())
            .commit()
    }

    override fun showRoundBegin(round: Round) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWord(word: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTimePassed(current: Int, max: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startRound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pauseRound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resumeRound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRoundEnd(game: Game) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWordGuessed(wordsGuessed: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWordsLeft(wordsLeft: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFinishGame(currentGame: Game) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
