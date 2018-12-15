package ru.androidacademy.ateam

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.deck_item.view.*


class DecksChooseListAdapter(
    var items: List<Deck> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return DeckHolder(inflater.inflate(R.layout.deck_item,p0,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = items[p1]

        (p0 as DeckHolder).bind(item)
    }

    class DeckHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.deck_item_text_view_name

        fun bind(d:Deck){
            name.text = d.deckName
        }
    }

}