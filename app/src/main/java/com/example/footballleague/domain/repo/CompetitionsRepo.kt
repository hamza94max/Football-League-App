package com.example.footballleague.domain.repo

import com.example.footballleague.domain.models.CompetitionsResponse

interface CompetitionsRepo {

    suspend fun getCompetitions(): CompetitionsResponse

}
