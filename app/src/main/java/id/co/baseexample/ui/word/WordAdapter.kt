package id.co.baseexample.ui.word

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.baseexample.R
import id.co.baseexample.data.entity.WordEntity
import kotlinx.android.synthetic.main.word_item.view.*


class WordAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var dataWord = emptyList<WordEntity>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.word_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun getItemCount() = dataWord.size

    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        val current = dataWord[position]
        holder.wordItemView.text = current.word
    }

    internal fun setWords(words: List<WordEntity>) {
        this.dataWord = words
        notifyDataSetChanged()
    }

}