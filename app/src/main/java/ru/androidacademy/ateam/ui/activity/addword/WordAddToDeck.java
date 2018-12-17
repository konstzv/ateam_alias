package ru.androidacademy.ateam.ui.activity.addword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import ru.androidacademy.ateam.App;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.model.AppDataBase;
import ru.androidacademy.ateam.model.dao.DeckDao;
import ru.androidacademy.ateam.model.dao.WordDao;
import ru.androidacademy.ateam.model.tables.Deck;
import ru.androidacademy.ateam.model.tables.Word;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class WordAddToDeck extends AppCompatActivity {
    Button btnSave;
    EditText editText;
    String temp;
    AppDataBase db = App.getDbInstance();
    WordDao wordDao = db.wordDao();
    Word word = new Word();
    DeckDao deckDao= db.deckDao();
    Deck deck = new Deck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_add_to_deck);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bar_add_words);

        btnSave = findViewById(R.id.btn_save_word);
        editText = findViewById(R.id.word_add_edit_text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = editText.getText().toString();
                Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        String[] s = checkString(temp);
                        for (int i = 0; i< s.length; i++){
                            word.deckId = 3;
                            word.word = s[i];
                            wordDao.insert(word);
                        }
                       deck.countWordInDeck = wordDao.getCountWordsById(3);
                       deckDao.insert(deck);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
               }
        });

    }
    private String[] checkString(String temp) {
        String[] tempStr = temp.split(",");
        for (int i = 0; i < tempStr.length; i++) {
            tempStr[i] = tempStr[i].trim();
            Log.d("Taf", tempStr[i]);
        }
        return tempStr;
    }
}
