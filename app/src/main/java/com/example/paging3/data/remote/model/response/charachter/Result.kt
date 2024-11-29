package com.example.paging3.data.remote.model.response.charachter

import com.example.paging3.data.remote.model.response.charachter.Url

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)