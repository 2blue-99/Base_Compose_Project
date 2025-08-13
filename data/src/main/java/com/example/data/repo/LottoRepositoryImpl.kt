package com.lucky_lotto.data.repo

import com.example.data.remote.datasource.LottoDataSourceImpl
import com.example.domain.repository.LottoRepository
import javax.inject.Inject

class LottoRepositoryImpl @Inject constructor(
    private val lottoDataSource: LottoDataSourceImpl
): LottoRepository {
//    override fun getLottoRoundDao(): Flow<List<LottoRound>> {
//        return lottoRoundDao.getLottoRoundDao().map { it.map { it.toDomain() } }
//    }
}