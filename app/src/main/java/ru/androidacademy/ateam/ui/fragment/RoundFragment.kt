package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.deck_item.*
import kotlinx.android.synthetic.main.fragment_round.*
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.ui.activity.RoundActivity


class RoundFragment : Fragment() {

    private lateinit var mTimeTv: TextView
    private lateinit var mWordTv: TextView
    private lateinit var mButtonOk: Button
    private lateinit var mButtonSkip: Button
    private lateinit var mProgressBar: MaterialProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_round, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mTimeTv = view.findViewById(R.id.timer_text_view)
//        mWordTv = view.findViewById(R.id.word_tv)
//        mButtonOk = view.findViewById(R.id.ok_button)
//        mButtonSkip = view.findViewById(R.id.skip_button)
//        mProgressBar = view.findViewById(R.id.timer_progress)
//
//        mProgressBar.visibility = View.VISIBLE
        ok_button.setOnClickListener{
            (activity as RoundActivity).nextWord()
        }
    }

    fun setWord(word:String){
        word_tv.text = word
    }

    fun setWordsLeft(wordsLeft: Int) {
        deck_item_text_view_word_count.text = wordsLeft.toString()
    }

}
