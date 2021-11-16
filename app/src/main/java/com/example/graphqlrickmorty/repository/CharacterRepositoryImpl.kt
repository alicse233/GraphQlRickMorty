package com.example.graphqlrickmorty.repository

import com.example.graphqlrickmorty.network.RickMortyApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
) : CharacterRepository {

}