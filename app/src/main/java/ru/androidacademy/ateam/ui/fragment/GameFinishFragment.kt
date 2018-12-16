package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.game_finish_fragment.*
import kotlinx.android.synthetic.main.round_begin_fragment.*
import kotlinx.android.synthetic.main.round_end_fragment.*
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.presentation.presenter.RoundResultPresenter
import ru.androidacademy.ateam.presentation.view.RoundResultView
import ru.androidacademy.ateam.ui.activity.RoundActivity




class GameFinishFragment: MvpAppCompatFragment(), RoundResultView {
    @InjectPresenter
    lateinit var presenter: RoundResultPresenter

    override fun show(game: Game) {
        game.getWinner()?.let {
            winner_team_name_tv.text = it.name
            score.text= it.score.toString()
        }?:run{
            team_name_tv.text = "Ничья"
        }


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.game_finish_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        finish_button.setOnClickListener{
            (activity as RoundActivity).onGameFinished()
        }
    }

}