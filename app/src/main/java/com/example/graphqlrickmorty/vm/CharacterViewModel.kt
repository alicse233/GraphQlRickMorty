package com.example.graphqlrickmorty.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.exception.ApolloException
import com.example.graphqlrickmorty.CharactersListQuery
import com.example.graphqlrickmorty.extra.ViewState
import com.example.graphqlrickmorty.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repo: CharacterRepository
): ViewModel() {

    private val _characterList by lazy {
        MutableStateFlow<ViewState<CharactersListQuery.Data>>(ViewState.Loading())
    }
    val characterList: StateFlow<ViewState<CharactersListQuery.Data>>
    get() = _characterList.asStateFlow()

    fun queryCharacterList() = viewModelScope.launch {
        try {
            val response = repo.getCharacterListFromBackend()
            _characterList.value = ViewState.Success(response.data)
        } catch (e: ApolloException) {
            _characterList.value = ViewState.Error(e.localizedMessage, null)
        }
    }
}