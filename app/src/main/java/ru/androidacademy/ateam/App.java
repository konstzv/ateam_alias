package ru.androidacademy.ateam;

import android.app.Application;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


    }

//    public static App getInstance() {
//        return instance;
//    }
//
//    public static AppDataBase getDbInstance() {
//        return appDataBase;
//    }
//
//    private void initWord() {
//        wordItem.text = "Синтаксис";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Шифрование";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Java";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Дерево";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Тред";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Баг";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "SQL";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Mock";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Ядро";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Сортировка";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Функция";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Стек";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Индекс";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Git";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Демон";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Concurrancy";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Локализация";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Файл";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Deadlock";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Билд";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Процессор";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Массив";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Integer";
//        wordItem.deckId = 1;
//        wordDao.insert(wordItem);
//        wordItem.text = "Lambda";
//
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Интерпретатор";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Демо";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Websocket";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Timeout";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Дедупликация";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Selenium";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Upgrade";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Bundle";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Цикл";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Свайп";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Куча";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Рекурсия";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Инкапсуляция";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Производительность";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Фреймворк";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Habr";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Деплой";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Crash";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Инфраструктура";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Commit";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Наследование";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Аргумент";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Гейзенбаг";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Асинхронность";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Рендеринг";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Консоль";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Программист";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Скрипт";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Manifest";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Github";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Модуляризация";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Бэклог";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Bash";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Request";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Буфер";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//        wordItem.text = "Dictionary";
//        wordItem.deckId = 2;
//        wordDao.insert(wordItem);
//
//    }
//
//    private void initDeck() {
//            deck.deckName = "Колода А";
//            deck.dificult = 1;
//            deck.countWordInDeck = wordDao.getCountWordsById(1);
//            deckDao.insert(deck);
//
//            deck.deckName = "Колода Б";
//            deck.dificult = 1;
//            deck.countWordInDeck = wordDao.getCountWordsById(2);
//            deckDao.insert(deck);
//
//        deck.deckName = "Гори она огнем";
//        deck.dificult = 1;
//        deck.countWordInDeck = 6;
//        deckDao.insert(deck);
//        }
}
