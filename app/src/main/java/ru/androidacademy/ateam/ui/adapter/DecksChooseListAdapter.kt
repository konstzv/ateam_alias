package ru.androidacademy.ateam.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.deck_item.view.*
import ru.androidacademy.ateam.Deck
import ru.androidacademy.ateam.R


class DecksChooseListAdapter(
    var items: ArrayList<Deck> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

     val onDeckItemClickPublishSubject = PublishSubject.create<Deck>()


    fun addDeck(d: Deck){
        items.add(d)
        notifyItemInserted(itemCount - 1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return DeckHolder(inflater.inflate(R.layout.deck_item, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = items[p1]

        (p0 as DeckHolder).bind(item)
    }

    inner class DeckHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.deck_item_text_view_name
        //        private val level = view.deck_item_text_view_level
        private val wordCount = view.deck_item_text_view_word_count

        fun bind(d: Deck) {
            name.text = d.deckName
            itemView.setOnClickListener{
                onDeckItemClickPublishSubject.onNext(d)
            }

        }
    }

}