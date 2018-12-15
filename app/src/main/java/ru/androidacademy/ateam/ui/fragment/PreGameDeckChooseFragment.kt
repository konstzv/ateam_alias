package ru.androidacademy.ateam.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.pre_game_deck_choose_fragment.*
import ru.androidacademy.ateam.Deck
import ru.androidacademy.ateam.R

import ru.androidacademy.ateam.ui.adapter.DecksChooseListAdapter


class PreGameDeckChooseFragment:MvpAppCompatFragment(){

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
        val deck = Deck()
        deck.deckName = "Андройдик"
        deck.dificult = 1
        showDecks(arrayListOf(deck,deck,deck))

    }
}