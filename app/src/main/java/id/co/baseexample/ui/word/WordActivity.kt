package id.co.baseexample.ui.word

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.baseexample.R
import id.co.baseexample.data.entity.WordEntity
import id.co.baseexample.data.model.Word
import kotlinx.android.synthetic.main.activity_word.*

class WordActivity : AppCompatActivity() {
    var adapter: WordAdapter? = null
    var viewModel: WordViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        adapter = WordAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel = WordViewModel(this.application)

        viewModel?.getAll?.observe(this, Observer {
            if(it.count() > 0) {
                adapter?.setWords(it)
            }
        })

        fab.setOnClickListener {
            viewModel?.insert(WordEntity(
                0,
                "hai"
            ))
        }

    }
}
