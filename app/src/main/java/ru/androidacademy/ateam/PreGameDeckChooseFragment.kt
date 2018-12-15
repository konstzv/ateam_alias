package ru.androidacademy.ateam

import android.os.Bundle
import android.provider.UserDictionary
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.pre_game_deck_choose_fragment.*
import org.jetbrains.anko.support.v4.selector
import org.jetbrains.anko.support.v4.toast


class PreGameDeckChooseFragment:MvpAppCompatFragment(){

 val adapter = DecksChooseListAdapter()

     fun showDecks( list:List<Deck>){
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
        showDecks(listOf(deck,deck,deck))

    }
}