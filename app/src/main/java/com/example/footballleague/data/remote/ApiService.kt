package com.example.footballleague.data.remote

import com.example.footballleague.domain.models.CompetitionsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("competitions/")
    suspend fun getCompetitions(): CompetitionsResponse

}