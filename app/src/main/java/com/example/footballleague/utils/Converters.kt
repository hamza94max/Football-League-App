package com.example.footballleague.utils

import androidx.room.TypeConverter
import com.example.footballleague.domain.models.Area
import com.example.footballleague.domain.models.CurrentSeason
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromJsonToArea(json: String?): Area? {
        return Gson().fromJson(json, Area::class.java)
    }

    @TypeConverter
    fun fromAreaToJson(area: Area?): String? {
        return Gson().toJson(area)
    }

    @TypeConverter
    fun fromJsonToCurrentSeason(json: String?): CurrentSeason? {
        return Gson().fromJson(json, CurrentSeason::class.java)
    }

    @TypeConverter
    fun fromCurrentSeasonToJson(currentSeason: CurrentSeason?): String? {
        return Gson().toJson(currentSeason)
    }
}