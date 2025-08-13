package com.lucky_lotto.data.local.di

import com.lucky_lotto.data.local.dao.KeywordDao
import com.example.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideKeywordDao(database: AppDatabase): KeywordDao =
        database.keywordDao()
}