package com.example.footballleague.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballleague.domain.models.Competition

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetitions(vararg competition: Competition)


    @Query("SELECT * FROM competitions_table")
    suspend fun getAllCompetitions(): List<Competition>


    @Query("DELETE FROM competitions_table")
    suspend fun deleteAllCompetitions()


}