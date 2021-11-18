package com.example.graphqlrickmorty.di

import com.example.graphqlrickmorty.repository.CharacterRepository
import com.example.graphqlrickmorty.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.hilt.android.scopes.ViewModelScoped

abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepo(repo: CharacterRepositoryImpl): CharacterRepository
}