package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import kotlinx.android.synthetic.main.round_begin_fragment.*
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.presentation.presenter.RoundResultPresenter
import ru.androidacademy.ateam.presentation.view.RoundResultView
import ru.androidacademy.ateam.ui.activity.RoundActivity




class RoundBeginFragment:MvpAppCompatFragment(),RoundResultView{
    @InjectPresenter
    lateinit var presenter:RoundResultPresenter

    override fun show(game: Game) {
        team_name_tv.text= game.currentRound.team.name
        player_op_name_tv.text= game.currentRound.playerAnswer.name
        player_name_tv.text= game.currentRound.playerExplain.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.round_begin_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start_button.setOnClickListener{
            (activity as RoundActivity).onRoundBeginClick()
        }
    }
}