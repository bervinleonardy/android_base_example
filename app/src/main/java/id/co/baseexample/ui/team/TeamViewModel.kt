package id.co.baseexample.ui.team

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.co.baseexample.data.api.ApiMain
import id.co.baseexample.data.database
import id.co.baseexample.data.entity.TeamEntity
import id.co.baseexample.data.entity.WordEntity
import id.co.baseexample.data.model.TeamResponse
import id.co.baseexample.data.repository.TeamRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class TeamViewModel(application: Application) : AndroidViewModel(application) {

    var repository: TeamRepository? = null
    var getAll: LiveData<List<TeamEntity>>? = null

    init {
        val teamDao = database.getDatabase(application).teamDao()
        repository = TeamRepository(teamDao)
        getAll = repository?.getAll
    }


    fun getTeams() {
        ApiMain().services.getAllTeam("4328").enqueue(object : retrofit2.Callback<TeamResponse> {
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.d("error get team", t.message)
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.code() == 200) {
                    response.body()?.teams?.let { insert(it) }
                    Log.d("response teams", response.body().toString())
                }
            }

        })
    }

    fun insert(team: List<TeamEntity>) = viewModelScope.launch {
        repository?.insertAll(team)
    }
}