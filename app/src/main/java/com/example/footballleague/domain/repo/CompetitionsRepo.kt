package com.example.footballleague.domain.repo

import com.example.footballleague.domain.models.Competition
import com.example.footballleague.domain.models.CompetitionsResponse
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepo {

    suspend fun fetchCompetitionsFromRemote(): CompetitionsResponse

    fun getCompetitionsFromDb(): Flow<List<Competition>>
    suspend fun cachingCompetitions()

    suspend fun insertCompetition()

    suspend fun deleteCompetitions()


}
