package com.example.footballleague.data.repoImpl

import com.example.footballleague.data.local.CompetitionDataBase
import com.example.footballleague.data.remote.ApiService
import com.example.footballleague.domain.models.Competition
import com.example.footballleague.domain.models.CompetitionsResponse
import com.example.footballleague.domain.repo.CompetitionsRepo
import com.example.footballleague.utils.NetworkHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CompetitionsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val competitionDataBase: CompetitionDataBase,
    private val networkHelper: NetworkHelper
) : CompetitionsRepo {


    override suspend fun fetchCompetitionsFromRemote(): CompetitionsResponse {
        return apiService.getCompetitions()
    }

    override fun getCompetitionsFromDb(): Flow<List<Competition>> = flow {
        emit(competitionDataBase.getCompetitionDao().getAllCompetitions())
    }

    override suspend fun cachingCompetitions() {
        if (competitionDataBase.getCompetitionDao().getAllCompetitions().isEmpty()) {
            if (networkHelper.isInternetAvailable()) {
                fetchCompetitionsFromRemote()
                deleteCompetitions()
                insertCompetition()
            }
        }
    }

    override suspend fun insertCompetition() {
        apiService.getCompetitions().competitions?.map { competition ->
            competitionDataBase.getCompetitionDao().insertCompetitions(competition)
        }
    }

    override suspend fun deleteCompetitions() {
        competitionDataBase.getCompetitionDao().deleteAllCompetitions()
    }
}