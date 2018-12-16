package ru.androidacademy.ateam.ui.activity.addword;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.androidacademy.ateam.App;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.model.AppDataBase;
import ru.androidacademy.ateam.model.dao.DeckDao;
import ru.androidacademy.ateam.model.tables.Deck;
import ru.androidacademy.ateam.ui.activity.addword.fragment.ListWordInDeckFragment;
import ru.androidacademy.ateam.ui.adapter.DecksChooseListAdapter;
import ru.androidacademy.ateam.ui.adapter.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.List;

public class ListWordActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DecksChooseListAdapter decksChooseListAdapter;
    AppDataBase db = App.getInstance().getDbInstance();
    DeckDao deckDao = db.deckDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_word);

        recyclerView = findViewById(R.id.add_word_activity_recycler);
        initRecyclerView(recyclerView, this);
        decksChooseListAdapter.getOnDeckItemClickPublishSubject().subscribe(
                new Consumer<Deck>() {
                    @Override
                    public void accept(Deck deck) throws Exception {
                        ListWordInDeckFragment listWordInDeckFragment = ListWordInDeckFragment.newInstance(deck.deckId, deck.deckName);
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.fragment, listWordInDeckFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );
        deckDao.getAllDeck()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<Deck>, Throwable>() {
                    @Override
                    public void accept(List<Deck> decks, Throwable throwable) throws Exception {
                        ArrayList<Deck> list = new ArrayList<>();
                        list.addAll(decks);
                        decksChooseListAdapter.setItems(list);
                        decksChooseListAdapter.notifyDataSetChanged();
                    }
                });

    }


    private void initRecyclerView(@NonNull RecyclerView recyclerView, @NonNull Context context) {
        decksChooseListAdapter = new DecksChooseListAdapter();
        recyclerView.addItemDecoration(new ItemOffsetDecoration(this, R.dimen.activity_padding_8dp));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(decksChooseListAdapter);
    }
}
