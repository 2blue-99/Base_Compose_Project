package com.example.data.remote.datasource

import com.example.data.util.apiErrorHandler
import com.lucky_lotto.data.remote.datasource.LottoDataSource
import com.example.data.remote.model.LottoResponse
import com.example.domain.util.APIResponseState
import javax.inject.Inject

class LottoDataSourceImpl @Inject constructor(
    private val lottoRetrofit: LottoDataSource
) {
    suspend fun requestLottoData(round: String): APIResponseState<LottoResponse> {
        return lottoRetrofit.requestLottoData(COMMON_METHOD, round).apiErrorHandler()
    }

    companion object {
        const val COMMON_METHOD = "getLottoNumber"
    }
}