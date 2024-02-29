package com.example.footballleague.di

import android.app.Application
import androidx.room.Room
import com.example.footballleague.data.local.CompetitionDataBase
import com.example.footballleague.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideCompetitionsDatabase(app: Application): CompetitionDataBase =
        Room.databaseBuilder(app, CompetitionDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}