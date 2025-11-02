package com.example.appdpa001.data.remote.apifootball

//Generando data class para las variables name, code y flag
data class Country(
    val name: String, val code: String?, val flag: String?)

//respuesta un data class
data class CountryResponse(val response: List<Country>)

data class Team(
    val id: Int,
    val name: String,
    val code: String,
    val logo: String,
    val country: String,
    val founded: Int?,
    val national: Boolean
)
data class TeamWrapper(
    val team: Team
)
data class TeamResponse(
    val response: List<TeamWrapper>
)


