package com.example.graphqlrickmorty.di

import com.example.graphqlrickmorty.repository.CharacterRepository
import com.example.graphqlrickmorty.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepo(repo: CharacterRepositoryImpl): CharacterRepository
}