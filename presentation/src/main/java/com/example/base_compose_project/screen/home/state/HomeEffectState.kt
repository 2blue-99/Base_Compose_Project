package com.example.base_compose_project.screen.home.state

import com.example.domain.util.CommonMessage

sealed class HomeEffectState {
    data class ShowToast(val message: CommonMessage): HomeEffectState()
    data class ShowSnackbar(val message: CommonMessage): HomeEffectState()
    data object NavigateToQR: HomeEffectState()
    data object NavigateToSetting: HomeEffectState()
    data object NavigateToRandom: HomeEffectState()
    data object NavigateToRecode: HomeEffectState()
    data object NavigateToStatistic: HomeEffectState()
}

