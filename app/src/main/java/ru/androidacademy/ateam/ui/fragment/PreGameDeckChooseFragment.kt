package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.pre_game_deck_choose_fragment.*
import ru.androidacademy.ateam.App

import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.AppDataBase
import ru.androidacademy.ateam.model.tables.Deck
import ru.androidacademy.ateam.presentation.presenter.SettingsPresenter
import ru.androidacademy.ateam.presentation.view.SettingsView
import ru.androidacademy.ateam.ui.activity.SettingsActivity

import ru.androidacademy.ateam.ui.adapter.DecksChooseListAdapter
import ru.androidacademy.ateam.ui.adapter.ItemOffsetDecoration


class PreGameDeckChooseFragment:MvpAppCompatFragment(),SettingsView{
    @InjectPresenter
    lateinit var presenter: SettingsPresenter

 val adapter = DecksChooseListAdapter()

     fun showDecks( list:ArrayList<Deck>){
         adapter.items = list
         adapter.notifyDataSetChanged()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.pre_game_deck_choose_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                pre_game_deck_choose_fragment_decs_list.layoutManager = LinearLayoutManager(context)
        pre_game_deck_choose_fragment_decs_list.adapter = adapter
        pre_game_deck_choose_fragment_decs_list.addItemDecoration(ItemOffsetDecoration(context!!,R.dimen.padding_4dp))
        App.getDbInstance().deckDao().allDeck.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeBy (
            onSuccess = {
                val arr = arrayListOf<Deck>()
                arr.addAll(it)
                showDecks(arr)
            }
        )
       adapter.onDeckItemClickPublishSubject.subscribeBy {
           App.getDbInstance().wordDao().getAllWordByDeckId(it.deckId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeBy (
               onSuccess = {
                   presenter.currentGame.words = it.map { it.word }
                   (activity as SettingsActivity).onCardChoosed()
               }
           )
       }
//        pre_game_deck_choose_fragment_decs_list.layoutManager = LinearLayoutManager(context)
//        pre_game_deck_choose_fragment_decs_list.adapter = adapter
//        val deck = Deck()
//        deck.deckName = "Андройдик"
//        deck.dificult = 1
//        showDecks(arrayListOf(deck,deck,deck))

    }
}

