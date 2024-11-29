package com.example.paging3.data.remote.model.response.charachter

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)