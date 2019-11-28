package id.co.baseexample.ui.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.baseexample.R
import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity() {
    var adapter: TeamAdapter? =null
    var viewModel: TeamViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        adapter = TeamAdapter(this)
        rv_team.adapter = adapter
        rv_team.layoutManager = LinearLayoutManager(this)

        viewModel = TeamViewModel(this.application)

        viewModel?.getTeams()

        viewModel?.getAll?.observe(this, Observer {
            if(it.count() > 0) {
                adapter?.setData(it)
            }
        })
    }
}
