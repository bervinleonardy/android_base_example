package id.co.baseexample.data.model

import id.co.baseexample.data.entity.TeamEntity

open class BaseResponse(
    val success: Boolean? = null,
    val errorCode: Int? = null,
    val message: String? = null
)

data class TeamResponse(
    var teams: List<TeamEntity>
)