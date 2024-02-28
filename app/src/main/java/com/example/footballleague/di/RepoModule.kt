package com.example.footballleague.di

import com.example.footballleague.data.remote.ApiService
import com.example.footballleague.data.repoImpl.CompetitionsRepoImpl
import com.example.footballleague.domain.repo.CompetitionsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun provideAuthRepo(apiService: ApiService): CompetitionsRepo {
        return CompetitionsRepoImpl(apiService)
    }
}