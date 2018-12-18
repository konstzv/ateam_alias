package ru.androidacademy.ateam.ui.activity.addword;


import androidx.appcompat.app.AppCompatActivity;

public class ListWordActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//    DecksChooseListAdapter decksChooseListAdapter;
//    AppDataBase db = App.getInstance().getDbInstance();
//    DeckDao deckDao = db.deckDao();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_word);
//        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bar_word_list);
//
//        recyclerView = findViewById(R.id.add_word_activity_recycler);
//        initRecyclerView(recyclerView, this);
//        decksChooseListAdapter.getOnDeckItemClickPublishSubject().subscribe(
//                new Consumer<Deck>() {
//                    @Override
//                    public void accept(Deck deck) throws Exception {
//                        ListWordInDeckFragment listWordInDeckFragment = ListWordInDeckFragment.newInstance(deck.deckId, deck.deckName);
//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        ft.add(R.id.fragment, listWordInDeckFragment);
//                        ft.addToBackStack(null);
//                        ft.commit();
//                    }
//                }
//        );
//        deckDao.getAllDeck()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BiConsumer<List<Deck>, Throwable>() {
//                    @Override
//                    public void accept(List<Deck> decks, Throwable throwable) throws Exception {
//                        ArrayList<Deck> list = new ArrayList<>();
//                        list.addAll(decks);
//                        decksChooseListAdapter.setItems(list);
//                        decksChooseListAdapter.notifyDataSetChanged();
//                    }
//                });
//
//    }
//
//
//    private void initRecyclerView(@NonNull RecyclerView recyclerView, @NonNull Context context) {
//        decksChooseListAdapter = new DecksChooseListAdapter();
//        recyclerView.addItemDecoration(new ItemOffsetDecoration(this, R.dimen.activity_padding_8dp));
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setAdapter(decksChooseListAdapter);
//    }
}
