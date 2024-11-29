package com.example.paging3.di

  import dagger.Module
 import dagger.hilt.InstallIn
 import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Singleton
//    @Provides
//    fun provideApplication(@ApplicationContext app: Context): MainApplication {
//        return app as MainApplication
//    }

}