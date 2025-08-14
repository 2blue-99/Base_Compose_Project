package com.example.base_compose_project.screen.home.state

sealed class HomeActionState {
    // 추첨 회차 인덱스 변경
    data class OnChangeRoundPosition(val targetRound: Int): HomeActionState()
    data class ShowDialog(val spinnerItem: String): HomeActionState()
    data object HideDialog: HomeActionState()
}