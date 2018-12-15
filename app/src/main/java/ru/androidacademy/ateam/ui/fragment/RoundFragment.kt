package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

import ru.androidacademy.ateam.R


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

        mTimeTv = view.findViewById(R.id.timer_text_view)
        mWordTv = view.findViewById(R.id.word_tv)
        mButtonOk = view.findViewById(R.id.ok_button)
        mButtonSkip = view.findViewById(R.id.skip_button)
        mProgressBar = view.findViewById(R.id.timer_progress)

        mProgressBar.visibility = View.VISIBLE
    }
}
