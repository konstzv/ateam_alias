package ru.androidacademy.ateam.ui.fragment

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_game_settings.*
import org.jetbrains.anko.support.v4.startActivity
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.presentation.presenter.SettingsPresenter
import ru.androidacademy.ateam.presentation.view.SettingsView
import ru.androidacademy.ateam.ui.activity.MainActivity
import ru.androidacademy.ateam.ui.activity.RoundActivity


class BasicSettingsFragment:MvpAppCompatFragment(),SettingsView{

   @InjectPresenter
   lateinit var presenter:SettingsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


       return inflater.inflate(R.layout.fragment_game_settings,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skip_seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                skip_value.text = (p1/3).toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        skip_value.text = (skip_seekBar.progress / 3).toString()
        start_game_button.setOnClickListener{
            Log.d("GAME",presenter.currentGame.toString())
            presenter.currentGame.timeInSec = time_seekBar.progress + 20
            presenter.currentGame.skipNum = skip_seekBar.progress / 3
            activity?.finish()
            startActivity<RoundActivity>()
        }
        time_for_turn.text = (time_seekBar.progress + 20).toString()
        time_seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                time_for_turn.text = (p1 + 20).toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

}