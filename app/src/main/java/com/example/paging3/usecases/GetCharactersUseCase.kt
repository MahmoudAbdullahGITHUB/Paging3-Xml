package com.example.paging3.usecases

import androidx.paging.PagingData
import com.example.paging3.data.remote.model.response.charachter.CharacterDataWrapper
import com.example.paging3.data.remote.model.response.charachter.Result
import com.example.paging3.pagination.ItemRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke(): Flow<PagingData<Result>> =
        repository.getItems()

    fun getResponseFlow(): StateFlow<CharacterDataWrapper?> {
        return repository.getResponseFlow()
    }
}
