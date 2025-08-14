package com.example.base_compose_project.screen.home.state

import com.example.base_compose_project.base.UIEvent

sealed class HomeEventState: UIEvent {
    // 추첨 회차 인덱스 변경
    data class OnChangeRoundPosition(val targetRound: Int): HomeEventState()
    data class ShowDialog(val spinnerItem: String): HomeEventState()
    data object HideDialog: HomeEventState()
}