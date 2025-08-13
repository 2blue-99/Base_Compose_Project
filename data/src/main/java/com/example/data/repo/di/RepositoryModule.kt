package com.example.data.repo.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
//    @Binds
//    abstract fun bindLottoRepository(lottoRepoImpl: LottoRepositoryImpl): LottoRepository
}