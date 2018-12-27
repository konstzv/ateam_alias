package ru.androidacademy.ateam.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ru.androidacademy.ateam.db.AppDatabase
import ru.androidacademy.ateam.model.Deck
import ru.androidacademy.ateam.model.Word
import toothpick.ProvidesSingletonInScope
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
@ProvidesSingletonInScope
class DataBaseProvider : Provider<AppDatabase> {

    companion object {
        val TAG = "DataBaseProvider"
    }

    @Inject
    lateinit var context: Context


    override fun get(): AppDatabase = Room
        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "alias")
        .fallbackToDestructiveMigration()
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                addBaseDecks()
                    .andThen(addBaseWords())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeBy(
                        onError = {
                            Log.e(TAG, "Database  pre population error: {${it.localizedMessage}}")
                        }
                    )
            }
        })
        .build()

    private fun addBaseDecks(): Completable {

        val deck = Deck("IT", 2)
        val decks = listOf(deck)

        return get().deckDao()
            .insertDeckList(decks)


    }

    private fun addBaseWords(): Completable {
        return get()
            .deckDao()
            .getDeckByName("IT")
            .flatMapCompletable { addWordsStringsToDeck(getBasITWordStrings(), it.first().id) }

    }

    private fun addWordsStringsToDeck(list: List<String>, deckId: Long): Completable {
        val words = arrayListOf<Word>()
        for (word in list) {
            words.add(Word(word, deckId))
        }
        return get().wordDao().insertAll(words)
    }

    private fun getBasITWordStrings(): List<String> {
        return listOf(
            "Синтаксис"
            , "Шифрование"
            , "Java"
            , "Дерево"
            , "Тред"
            , "Баг"
            , "SQL"
            , "Ядро"
            , "Mock"
            , "Сортировка"
            , "Функция"
            , "Стек"
            , "Индекс"
            , "Git"
            , "Демон"
            , "Concurrency"
            , "Локализация"
            , "Файл"
            , "Deadlock"
            , "Билд"
            , "Процессор"
            , "Массив"
            , "Integer"
            , "Lambda"
            , "Интерпретатор"
            , "Демо"
            , "Websocket"
            , "Timeout"
            , "Дедупликация"
            , "Selenium"
            , "Upgrade"
            , "Bundle"
            , "Цикл"
            , "Свайп"
            , "Куча"
            , "Рекурсия"
            , "Инкапсуляция"
            , "Производительность"
            , "Фреймворк"
            , "Habr"
            , "Деплой"
            , "Crash"
            , "Инфраструктура"
            , "Commit"
            , "Наследование"
            , "Аргумент"
            , "Гейзенбаг"
            , "Асинхронность"
            , "Рендеринг"
            , "Консоль"
            , "Программист"
            , "Скрипт"
            , "Manifest"
            , "Github"
            , "Модуляризация"
            , "Бэклог"
            , "Bash"
            , "Request"
            , "Request"
            , "Dictionary"
        )

    }

}