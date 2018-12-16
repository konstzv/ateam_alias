package ru.androidacademy.ateam.ui.activity.addword.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import ru.androidacademy.ateam.App;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.model.AppDataBase;
import ru.androidacademy.ateam.model.dao.WordDao;
import ru.androidacademy.ateam.model.tables.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddWordInDeckFragment extends Fragment {
    RecyclerView recyclerView;
    AddWordAdapter adapter;
    TextView deckName;
    AppDataBase db = App.getInstance().getDbInstance();
    WordDao wordDao = db.wordsDao();
    Word dictWord = new Word();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_word_in_deck, container, false);

        recyclerView = v.findViewById(R.id.add_word_recycler);
        initRecyclerView(recyclerView, v.getContext());
        deckName = v.findViewById(R.id.add_word_title);
        deckName.setText("Deck");

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                if (wordDao.getCountWords() == 0){
                    Log.d("TAg", db.toString());
                wordDao.insertWordList(initDb());}

            }
        })
                .subscribeOn(Schedulers.io())
                .andThen(wordDao.getAllWordByDeckId(1L))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<Word>, Throwable>() {
                    @Override
                    public void accept(List<Word> list, Throwable throwable) throws Exception {
                        adapter.replaceItems(list);
                    }
                });

        return v;
    }


    private void initRecyclerView(@NonNull RecyclerView recyclerView, @NonNull Context context) {
        adapter = new AddWordAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new AddWordDecorator(getResources().getDimensionPixelSize(R.dimen.padding_4dp)));
    }



    public List<Word> initDb() {
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dictWord.word = "word +" +i;
            dictWord.deckId = 1L;
            wordDao.insert(dictWord);
            list.add(dictWord);
        }
        return list;
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


}
