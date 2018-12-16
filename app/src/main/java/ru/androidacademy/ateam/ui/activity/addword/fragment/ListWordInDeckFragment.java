package ru.androidacademy.ateam.ui.activity.addword.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import ru.androidacademy.ateam.App;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.model.AppDataBase;
import ru.androidacademy.ateam.model.dao.WordDao;
import ru.androidacademy.ateam.model.tables.Word;
import ru.androidacademy.ateam.ui.activity.addword.ListWordActivity;
import ru.androidacademy.ateam.ui.activity.addword.WordAddToDeck;

import java.util.List;

public class ListWordInDeckFragment extends Fragment {
    RecyclerView recyclerView;
    ListWordAdapter adapter;
    TextView deckName;
    AppDataBase db = App.getInstance().getDbInstance();
    WordDao wordDao = db.wordDao();
    long id;
    String deckTitle;

    Button btnAddWord;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = -1;
        id = getArguments().getLong("id", -1);
        deckTitle = getArguments().getString("name");
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        recyclerView = v.findViewById(R.id.add_word_recycler);
        initRecyclerView(recyclerView, v.getContext());
        deckName = v.findViewById(R.id.add_word_title);
        btnAddWord = v.findViewById(R.id.add_word_btn);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ListWordActivity) getActivity()).openWordToAdd();
//             WordAddToDeck wordAddToDeck = WordAddToDeck.newInstance(id);

            }
        });
        wordDao.getAllWordByDeckId(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<Word>, Throwable>() {
                    @Override
                    public void accept(List<Word> list, Throwable throwable) throws Exception {
                        adapter.replaceItems(list);
                    }
                });
        deckName.setText(deckTitle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_word_in_deck, container, false);
        return v;
    }



    private void initRecyclerView(@NonNull RecyclerView recyclerView, @NonNull Context context) {
        adapter = new ListWordAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new ListWordDecorator(getResources().getDimensionPixelSize(R.dimen.padding_4dp)));
    }

    public static ListWordInDeckFragment newInstance(long id, String deckTitle) {

        Bundle args = new Bundle();
        args.putLong("id", id);
        args.putString("name", deckTitle);
        ListWordInDeckFragment fragment = new ListWordInDeckFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
