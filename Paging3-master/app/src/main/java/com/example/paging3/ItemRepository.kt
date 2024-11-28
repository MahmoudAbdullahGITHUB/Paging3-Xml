package com.example.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class ItemRepository {
    fun getItems(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = 2,
                enablePlaceholders = false,
                prefetchDistance = 1
            ),
            pagingSourceFactory = { StaticPagingSource() }
        ).flow
    }
}
