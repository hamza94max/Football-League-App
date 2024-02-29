package com.example.footballleague.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.footballleague.domain.models.Competition
import com.example.footballleague.utils.Converters

@Database(entities = [Competition::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CompetitionDataBase : RoomDatabase() {

    abstract fun getCompetitionDao(): CompetitionDao

}