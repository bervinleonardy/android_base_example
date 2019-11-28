package id.co.baseexample.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import id.co.baseexample.data.dao.WordDao
import id.co.baseexample.data.entity.WordEntity

class WordRepository (private val wordDao: WordDao) {
    val getAll: LiveData<List<WordEntity>> = wordDao.getAll()

    fun insert(word: WordEntity) {
        AsyncTask.execute {
            wordDao.insertAll(word)
        }
    }
}