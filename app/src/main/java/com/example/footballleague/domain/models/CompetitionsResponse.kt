package com.example.footballleague.domain.models

data class CompetitionsResponse(
    val competitions: List<Competition>? = mutableListOf(),
    val count: Int? = 0,
    val filters: Filters = Filters()
)

data class Competition(
    val area: Area? = Area(),
    val code: String? = "",
    val currentSeason: CurrentSeason? = CurrentSeason(),
    val emblem: String? = "",
    val id: Int? = 0,
    val lastUpdated: String? = "",
    val name: String? = "",
    val numberOfAvailableSeasons: Int? = 0,
    val plan: String? = "",
    val type: String? = ""
)

data class Area(
    val code: String? = "",
    val flag: String? = "",
    val id: Int? = 0,
    val name: String? = ""
)

data class CurrentSeason(
    val currentMatchday: Int? = 0,
    val endDate: String? = "",
    val id: Int? = 0,
    val startDate: String? = "",
    val winner: Winner? = Winner()
)


data class Winner(
    val address: String? = "",
    val clubColors: String? = "",
    val crest: String? = "",
    val founded: Int? = 0,
    val id: Int? = 0,
    val lastUpdated: String? = "",
    val name: String? = "",
    val shortName: String? = "",
    val tla: String? = "",
    val venue: String? = "",
    val website: String? = ""
)

class Filters