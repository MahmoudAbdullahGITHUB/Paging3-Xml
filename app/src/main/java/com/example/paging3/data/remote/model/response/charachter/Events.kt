package com.example.paging3.data.remote.model.response.charachter

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)