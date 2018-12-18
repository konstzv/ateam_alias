package ru.androidacademy.ateam.ui.activity.addword;

import androidx.appcompat.app.AppCompatActivity;

public class WordAddToDeck extends AppCompatActivity {
//    Button btnSave;
//    EditText editText;
//    String temp;
//    AppDataBase db = App.getDbInstance();
//    WordDao wordDao = db.wordDao();
//    Word word = new Word();
//    DeckDao deckDao= db.deckDao();
//    Deck deck = new Deck();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_word_add_to_deck);
//        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bar_add_words);
//
//        btnSave = findViewById(R.id.btn_save_word);
//        editText = findViewById(R.id.word_add_edit_text);
//
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                temp = editText.getText().toString();
//                Completable.fromAction(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        String[] s = checkString(temp);
//                        for (int i = 0; i< s.length; i++){
//                            word.deckId = 3;
//                            word.text = s[i];
//                            wordDao.insert(word);
//                        }
//                       deck.countWordInDeck = wordDao.getCountWordsById(3);
//                       deckDao.insert(deck);
//                    }
//                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
//               }
//        });
//
//    }
//    private String[] checkString(String temp) {
//        String[] tempStr = temp.split(",");
//        for (int i = 0; i < tempStr.length; i++) {
//            tempStr[i] = tempStr[i].trim();
//            Log.d("Taf", tempStr[i]);
//        }
//        return tempStr;
//    }
}
