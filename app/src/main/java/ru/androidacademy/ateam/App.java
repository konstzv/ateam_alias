package ru.androidacademy.ateam;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import ru.androidacademy.ateam.model.AppDataBase;
import ru.androidacademy.ateam.model.dao.DeckDao;
import ru.androidacademy.ateam.model.dao.WordDao;
import ru.androidacademy.ateam.model.tables.Deck;
import ru.androidacademy.ateam.model.tables.Word;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static App instance;
    Word wordItem = new Word();
    Deck deck = new Deck();
    WordDao wordDao;
    DeckDao deckDao;

    private static AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appDataBase = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();
        wordDao = appDataBase.wordDao();
        deckDao = appDataBase.deckDao();
        Completable.fromAction(new Action() {

            @Override
            public void run() throws Exception {
                if (deckDao.getAllDeckCount() == 0) {
                    initWord();
                    initDeck();
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public static App getInstance() {
        return instance;
    }

    public static AppDataBase getDbInstance() {
        return appDataBase;
    }

    private void initWord() {
        wordItem.word = "Синтаксис";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Шифрование";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Java";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Дерево";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Тред";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Баг";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "SQL";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Mock";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Ядро";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Сортировка";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Функция";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Стек";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Индекс";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Git";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Демон";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Concurrancy";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Локализация";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Файл";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Deadlock";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Билд";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Процессор";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Массив";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Integer";
        wordItem.deckId = 1;
        wordDao.insert(wordItem);
        wordItem.word = "Lambda";

        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Интерпретатор";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Демо";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Websocket";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Timeout";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Дедупликация";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Selenium";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Upgrade";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Bundle";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Цикл";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Свайп";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Куча";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Рекурсия";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Инкапсуляция";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Производительность";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Фреймворк";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Habr";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Деплой";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Crash";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Инфраструктура";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Commit";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Наследование";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Аргумент";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Гейзенбаг";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Асинхронность";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Рендеринг";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Консоль";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Программист";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Скрипт";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Manifest";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Github";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Модуляризация";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Бэклог";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Bash";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Request";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Буфер";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);
        wordItem.word = "Dictionary";
        wordItem.deckId = 2;
        wordDao.insert(wordItem);

    }

    private void initDeck() {
            deck.deckName = "Колода А";
            deck.dificult = 1;
            deck.countWordInDeck = wordDao.getCountWordsById(1);
            deckDao.insert(deck);

            deck.deckName = "Колода Б";
            deck.dificult = 1;
            deck.countWordInDeck = wordDao.getCountWordsById(2);
            deckDao.insert(deck);
        }
    }
