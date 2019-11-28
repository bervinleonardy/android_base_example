package id.co.baseexample.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "data_team")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("idTeam")
    var teamId: String? = null,
    @SerializedName("strTeam")
    var teamName: String? = null,
    @SerializedName("strSport")
    var teamSport: String? = null,
    @SerializedName("strTeamBadge")
    var teamBadge: String? = null,
    @SerializedName("strDescriptionEN")
    var teamDesc: String? = null,
    @SerializedName("intFormedYear")
    var teamFormedYear: String? = null,
    @SerializedName("strStadium")
    var teamStadium: String? = null,
    @SerializedName("strStadiumThumb")
    var teamStadiumImage: String? = null
)