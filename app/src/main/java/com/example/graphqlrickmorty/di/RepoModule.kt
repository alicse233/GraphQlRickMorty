package com.example.graphqlrickmorty.di

import com.example.graphqlrickmorty.network.RickMortyApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    fun provideWebAPI() = RickMortyApi()
}