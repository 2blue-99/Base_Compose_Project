package com.example.domain.repository

import kotlinx.coroutines.flow.Flow


interface UserRepository {
    val isRequireCameraPermission: Flow<Boolean>

    suspend fun setRequireCameraPermission(state: Boolean)
}