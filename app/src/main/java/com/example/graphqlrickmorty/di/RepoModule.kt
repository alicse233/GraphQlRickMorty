package com.example.graphqlrickmorty.di

import com.example.graphqlrickmorty.network.RickMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideWebAPI() = RickMortyApi()
}