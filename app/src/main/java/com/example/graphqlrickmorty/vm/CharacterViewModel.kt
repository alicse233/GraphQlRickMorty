package com.example.graphqlrickmorty.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlrickmorty.CharactersListQuery
import com.example.graphqlrickmorty.extra.ViewState
import com.example.graphqlrickmorty.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

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
        } catch (e: Exception) {
            _characterList.value = ViewState.Error(e.localizedMessage, null)
        }
    }
}