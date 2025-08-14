package com.example.base_compose_project.screen.home

import com.example.base_compose_project.base.BaseViewModel
import com.example.base_compose_project.screen.home.state.HomeEffectState
import com.example.base_compose_project.screen.home.state.HomeEventState
import com.example.base_compose_project.screen.home.state.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): BaseViewModel<HomeUIState, HomeEventState, HomeEffectState>() {
    override fun createInitialState(): HomeUIState = HomeUIState.Loading

    override fun handleEvent(event: HomeEventState) {
        when(event){
            is HomeEventState.OnChangeRoundPosition -> {}
            is HomeEventState.ShowDialog -> {}
            is HomeEventState.HideDialog -> {}
        }
    }

}