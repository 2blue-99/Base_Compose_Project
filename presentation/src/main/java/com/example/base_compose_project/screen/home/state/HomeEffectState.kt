package com.example.base_compose_project.screen.home.state

import com.example.base_compose_project.base.UIEffect
import com.example.domain.util.CommonMessage

sealed class HomeEffectState: UIEffect {
    data class ShowToast(val message: CommonMessage): HomeEffectState()
    data class ShowSnackbar(val message: CommonMessage): HomeEffectState()
    data object NavigateToQR: HomeEffectState()
}

