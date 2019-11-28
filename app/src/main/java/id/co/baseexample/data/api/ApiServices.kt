package id.co.baseexample.data.api

import id.co.baseexample.data.model.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("api/v1/json/1/lookup_all_teams.php")
    fun getAllTeam(@Query("id") id: String?): Call<TeamResponse>
}