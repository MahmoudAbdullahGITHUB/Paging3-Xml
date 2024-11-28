package com.example.paging3

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

class StaticPagingSource : PagingSource<Int, Item>() {

    private val staticList = listOf(
        Item(1, "Item 1"),
        Item(2, "Item 2"),
        Item(3, "Item 3"),
        Item(4, "Item 4"),
        Item(5, "Item 5"),
        Item(6, "Item 6"),
        Item(7, "Item 7"),
        Item(8, "Item 8"),
        Item(9, "Item 9"),
        Item(10,"Item 10"),
        Item(11,"Item 11"),
        Item(12,"Item 12"),
        Item(13,"Item 13"),
        Item(14,"Item 14"),
        Item(15,"Item 15"),
    )

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val pageNumber = params.key ?: 1
            val itemsPerPage = 4

            val startIndex = (pageNumber - 1) * itemsPerPage
            val endIndex = (startIndex + itemsPerPage).coerceAtMost(staticList.size)

            val pageItems = if (startIndex < staticList.size) {
                staticList.subList(startIndex, endIndex)
            } else {
                emptyList()
            }
            Log.d("StaticPagingSource", "Loaded page $pageNumber: $pageItems")

            LoadResult.Page(
                data = pageItems,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (endIndex == staticList.size) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
