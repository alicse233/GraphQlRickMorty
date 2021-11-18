package com.example.graphqlrickmorty.repository

import com.apollographql.apollo.api.Response
import com.example.graphqlrickmorty.CharactersListQuery

interface CharacterRepository {
    suspend fun getCharacterListFromBackend(): Response<CharactersListQuery.Data>
}