package id.co.baseexample.ui.word

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.co.baseexample.data.api.ApiMain
import id.co.baseexample.data.database
import id.co.baseexample.data.entity.WordEntity
import id.co.baseexample.data.model.TeamResponse
import id.co.baseexample.data.model.Word
import id.co.baseexample.data.repository.WordRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: WordRepository? = null

    var getAll: LiveData<List<WordEntity>>? = null

    init {
        val wordsDao = database.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        getAll = repository?.getAll
    }

    fun insert(word: WordEntity) = viewModelScope.launch {
        repository?.insert(word)
    }

}