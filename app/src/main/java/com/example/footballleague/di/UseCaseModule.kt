package com.example.footballleague.di

import com.example.footballleague.domain.repo.CompetitionsRepo
import com.example.footballleague.domain.usecase.GetCompetitionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    fun provideGetCompetitionsUseCase(competitionsRepo: CompetitionsRepo): GetCompetitionsUseCase {
        return GetCompetitionsUseCase(competitionsRepo)
    }


}