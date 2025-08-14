package com.example.base_compose_project.screen.home.state


sealed interface HomeUIState {

    data object Loading : HomeUIState

    data object Fail : HomeUIState

    data class Success(
        val initPosition: Int? = null // 회차 정보 세팅 인덱스
    ) : HomeUIState
}

