package id.co.baseexample.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.co.baseexample.data.entity.TeamEntity

@Dao
interface TeamDao {

    @Query("SELECT * FROM data_team LIMIT 5")
    fun getAll() : LiveData<List<TeamEntity>>

    @Insert
    fun insertAll(team: List<TeamEntity>?)
}