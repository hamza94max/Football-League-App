package com.example.footballleague.domain.usecase

import com.example.footballleague.domain.models.Competition
import com.example.footballleague.domain.repo.CompetitionsRepo
import kotlinx.coroutines.flow.Flow

class GetCompetitionsUseCase(private val competitionsRepo: CompetitionsRepo) {

    suspend operator fun invoke(): Flow<List<Competition>> {
        competitionsRepo.cachingCompetitions()
        return competitionsRepo.getCompetitionsFromDb()
    }

}