package com.example.footballleague.data.repoImpl

import com.example.footballleague.data.remote.ApiService
import com.example.footballleague.domain.models.CompetitionsResponse
import com.example.footballleague.domain.repo.CompetitionsRepo

class CompetitionsRepoImpl constructor(private val apiService: ApiService) : CompetitionsRepo {


    override suspend fun getCompetitions(): CompetitionsResponse {
        return apiService.getCompetitions()
    }
}