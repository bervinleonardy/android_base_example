package id.co.baseexample.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class WordEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var word: String
)