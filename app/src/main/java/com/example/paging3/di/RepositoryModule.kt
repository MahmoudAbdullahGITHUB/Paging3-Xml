package com.example.paging3.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideCharactersRepository(
//        marvelApiService: MarvelApiService,
//        mapper: RecipeDtoMapper,
//    ): CharactersRepository {
//        return RecipeRepositoryImpl(recipeService, mapper)
//    }
}