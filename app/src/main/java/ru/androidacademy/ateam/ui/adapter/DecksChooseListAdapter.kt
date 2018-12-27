package ru.androidacademy.ateam.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpDelegate
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.deck_item.view.*
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.Deck
import ru.androidacademy.ateam.presentation.presenter.DeckAdapterPresenter
import ru.androidacademy.ateam.presentation.view.DeckAdapterView


class DecksChooseListAdapter(
    var items: ArrayList<Deck> = arrayListOf(),
    mvpDelegate: MvpDelegate<*>

) : MvpRecyclerViewViewHolderAdapter(mvpDelegate, "0"), DeckAdapterView {

    @InjectPresenter
    lateinit var deckAdaPresenter: DeckAdapterPresenter

    public val onDeckItemClickPublishSubject = PublishSubject.create<Deck>()


    fun addDeck(d: Deck) {
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
        private val wordCount = view.deck_item_text_view_word_count2

        fun bind(d: Deck) {
            name.text = d.name
            deckAdaPresenter.getDeckWordCount(d.id).subscribeBy(
                onSuccess = {
                    wordCount.text = it.toString()
                }
            )
//            wordCount.text = d.dwordsNum.toString()
            itemView.setOnClickListener {
                onDeckItemClickPublishSubject.onNext(d)
            }

        }
    }

}