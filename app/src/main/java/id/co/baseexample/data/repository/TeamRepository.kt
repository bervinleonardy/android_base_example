package id.co.baseexample.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import id.co.baseexample.data.dao.TeamDao
import id.co.baseexample.data.entity.TeamEntity

class TeamRepository(val dao: TeamDao) {
    val getAll: LiveData<List<TeamEntity>> = dao.getAll()

    fun insertAll(team: List<TeamEntity>) {
        AsyncTask.execute {
            dao.insertAll(team)
        }
    }
}