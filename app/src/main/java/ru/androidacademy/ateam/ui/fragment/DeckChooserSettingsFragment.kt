package ru.androidacademy.ateam.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.pre_game_deck_choose_fragment.*
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.Deck
import ru.androidacademy.ateam.presentation.presenter.SettingsPresenter
import ru.androidacademy.ateam.presentation.view.SettingsView
import ru.androidacademy.ateam.repositories.IDeckRepository
import ru.androidacademy.ateam.repositories.IWordsRepository
import ru.androidacademy.ateam.ui.activity.SettingsActivity
import ru.androidacademy.ateam.ui.adapter.DecksChooseListAdapter
import ru.androidacademy.ateam.ui.adapter.ItemOffsetDecoration
import toothpick.Toothpick
import javax.inject.Inject


class DeckChooserSettingsFragment : MvpAppCompatFragment(), SettingsView {
    @InjectPresenter
    lateinit var presenter: SettingsPresenter

    @Inject
    lateinit var deckRepository: IDeckRepository


    @Inject
    lateinit var wordRepository: IWordsRepository

    val adapter = DecksChooseListAdapter(mvpDelegate = mvpDelegate)

    fun showDecks(list: ArrayList<Deck>) {
        adapter.items = list
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appScope = Toothpick.openScope(App.Scopes.GAME_SCOPE)
        Toothpick.inject(this, appScope)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pre_game_deck_choose_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pre_game_deck_choose_fragment_decs_list.layoutManager = LinearLayoutManager(context)
        pre_game_deck_choose_fragment_decs_list.adapter = adapter
        pre_game_deck_choose_fragment_decs_list.addItemDecoration(ItemOffsetDecoration(context!!, R.dimen.padding_4dp))
        deckRepository.getAllDecks().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeBy(
            onSuccess = {
                val arr = arrayListOf<Deck>()
                arr.addAll(it)
                showDecks(arr)
            }
        )
        adapter.onDeckItemClickPublishSubject.subscribeBy { deck ->
            wordRepository.gettWordsByDeckId(deck.id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(
                Schedulers.io()
            ).subscribeBy(
                onSuccess = { words ->
                    presenter.currentGame.words = words.map { it.text }
                    (activity as SettingsActivity).onCardChoosed()
                }
            )
        }
    }
}

