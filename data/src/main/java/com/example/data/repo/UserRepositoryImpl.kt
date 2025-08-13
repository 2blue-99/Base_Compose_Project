package com.lucky_lotto.data.repo

import com.example.domain.repository.UserRepository
import com.lucky_lotto.data.datastore.UserDataStore
import com.lucky_lotto.data.local.dao.KeywordDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val keywordDao: KeywordDao,
    private val userDataStore: UserDataStore
): UserRepository {

    override val isRequireCameraPermission: Flow<Boolean>
        get() = flow {  }

    override suspend fun setRequireCameraPermission(state: Boolean) {

    }
}