package com.example.paging3.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3.data.local.Item
import com.example.paging3.data.remote.model.response.charachter.CharacterDataWrapper
import com.example.paging3.data.remote.model.response.charachter.Result
import com.example.paging3.utils.Constants.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val source: StaticPagingSource
) {

    fun getItems(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
//                prefetchDistance = 1
            ),
            pagingSourceFactory = { source }
        ).flow
    }

    fun getResponseFlow(): StateFlow<CharacterDataWrapper?> {
        return source.responseFlow
    }

}
