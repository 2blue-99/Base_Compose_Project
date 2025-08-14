package com.example.base_compose_project.screen.home.state

import com.example.base_compose_project.base.UIState


sealed interface HomeUIState:UIState {

    data object Loading : HomeUIState

    data object Fail : HomeUIState

    data class Success(
        val initPosition: Int? = null // 회차 정보 세팅 인덱스
    ) : HomeUIState
}

