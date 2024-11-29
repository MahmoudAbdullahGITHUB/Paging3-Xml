package com.example.paging3.ui

import com.example.paging3.usecases.GetCharactersUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3.data.remote.model.response.charachter.CharacterDataWrapper
import com.example.paging3.data.remote.model.response.charachter.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val useCase: GetCharactersUseCase
) : ViewModel() {

    val items: Flow<PagingData<Result>> =
        useCase().cachedIn(viewModelScope)

    fun getResponseFlow(): StateFlow<CharacterDataWrapper?> =
        useCase.getResponseFlow()

}
