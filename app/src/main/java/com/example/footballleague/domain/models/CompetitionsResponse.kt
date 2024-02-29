package com.example.footballleague.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.footballleague.utils.Converters

data class CompetitionsResponse(
    val competitions: List<Competition>? = mutableListOf(),
    val count: Int? = 0,
    val filters: Filters = Filters()
)

@Entity(tableName = "competitions_table")
data class Competition(
    @TypeConverters(Converters::class)
    val area: Area? = Area(),
    val code: String? = "",
    @TypeConverters(Converters::class)
    val currentSeason: CurrentSeason? = CurrentSeason(),
    val emblem: String? = "",
    @PrimaryKey
    val id: Int? = 0,
    val lastUpdated: String? = "",
    val name: String? = "",
    val numberOfAvailableSeasons: Int? = 0,
    val plan: String? = "",
    val type: String? = ""
) : java.io.Serializable

data class Area(
    val code: String? = "",
    val flag: String? = "",
    val id: Int? = 0,
    val name: String? = ""
) : java.io.Serializable

data class CurrentSeason(
    val currentMatchday: Int = 0,
    val endDate: String? = "",
    val id: Int? = 0,
    val startDate: String? = "",
    @TypeConverters(Converters::class)
    val winner: Winner? = Winner()
) : java.io.Serializable


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
) : java.io.Serializable

class Filters