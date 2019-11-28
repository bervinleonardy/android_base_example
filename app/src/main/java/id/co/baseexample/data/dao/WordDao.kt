package id.co.baseexample.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import id.co.baseexample.data.entity.WordEntity
import id.co.baseexample.data.model.Word

@Dao
interface WordDao {
    @Insert
    fun insertAll(word: WordEntity)

    @Query("SELECT * FROM word_table")
    fun getAll() : LiveData<List<WordEntity>>

    @Delete
    fun deleteAll(word: WordEntity)
}