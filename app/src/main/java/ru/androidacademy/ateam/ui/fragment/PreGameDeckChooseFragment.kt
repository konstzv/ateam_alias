package ru.androidacademy.ateam.ui.fragment


import ru.androidacademy.ateam.presentation.view.SettingsView


class PreGameDeckChooseFragment:MvpAppCompatFragment(),SettingsView{
//    @InjectPresenter
//    lateinit var presenter: SettingsPresenter
//
// val adapter = DecksChooseListAdapter()
//
//     fun showDecks( list:ArrayList<Deck>){
//         adapter.items = list
//         adapter.notifyDataSetChanged()
//    }
//
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return  inflater.inflate(R.layout.pre_game_deck_choose_fragment,container,false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//                pre_game_deck_choose_fragment_decs_list.layoutManager = LinearLayoutManager(context)
//        pre_game_deck_choose_fragment_decs_list.adapter = adapter
//        pre_game_deck_choose_fragment_decs_list.addItemDecoration(ItemOffsetDecoration(context!!,R.dimen.padding_4dp))
//        App.getDbInstance().deckDao().allDeck.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeBy (
//            onSuccess = {
//                val arr = arrayListOf<Deck>()
//                arr.addAll(it)
//                showDecks(arr)
//            }
//        )
//
//       adapter.onDeckItemClickPublishSubject.subscribeBy {
//           App.getDbInstance().wordDao().getAllWordByDeckId(it.deckId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeBy (
//               onSuccess = {
//                   presenter.currentGame.words = it.map { it.text }
//                   (activity as SettingsActivity).onCardChoosed()
//               }
//           )
//
//
//       }
//
//
////        pre_game_deck_choose_fragment_decs_list.layoutManager = LinearLayoutManager(context)
////        pre_game_deck_choose_fragment_decs_list.adapter = adapter
////        val deck = Deck()
////        deck.deckName = "Андройдик"
////        deck.dificult = 1
////        showDecks(arrayListOf(deck,deck,deck))
//
//    }
}

