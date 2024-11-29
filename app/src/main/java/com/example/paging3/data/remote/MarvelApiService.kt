package com.example.paging3.data.remote

import com.example.paging3.data.remote.model.response.charachter.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<CharacterDataWrapper?>?

}