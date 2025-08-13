package com.example.data.repo

import com.example.domain.repository.UserRepository
import com.example.data.datastore.UserDataStore
import com.example.data.local.dao.KeywordDao
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