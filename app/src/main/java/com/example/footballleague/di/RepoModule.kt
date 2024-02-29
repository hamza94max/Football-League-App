package com.example.footballleague.di

import com.example.footballleague.data.local.CompetitionDataBase
import com.example.footballleague.data.remote.ApiService
import com.example.footballleague.data.repoImpl.CompetitionsRepoImpl
import com.example.footballleague.domain.repo.CompetitionsRepo
import com.example.footballleague.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideCompetitionsRepo(
        apiService: ApiService,
        competitionDataBase: CompetitionDataBase,
        networkHelper: NetworkHelper
    ): CompetitionsRepo {
        return CompetitionsRepoImpl(apiService, competitionDataBase, networkHelper)
    }
}