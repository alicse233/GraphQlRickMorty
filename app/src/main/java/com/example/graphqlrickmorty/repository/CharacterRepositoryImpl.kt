package com.example.graphqlrickmorty.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.graphqlrickmorty.CharactersListQuery
import com.example.graphqlrickmorty.network.RickMortyApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
) : CharacterRepository {

    override suspend fun getCharacterListFromBackend(): Response<CharactersListQuery.Data> {
        return api.getClient().query(CharactersListQuery()).await()
    }

}