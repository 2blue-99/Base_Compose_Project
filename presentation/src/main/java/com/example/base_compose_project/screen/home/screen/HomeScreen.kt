package com.example.base_compose_project.screen.home.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.base_compose_project.screen.home.HomeViewModel
import com.example.base_compose_project.screen.home.state.HomeEffectState
import com.example.base_compose_project.screen.home.state.HomeEventState
import com.example.base_compose_project.screen.home.state.HomeUIState

@Composable
fun HomeRoute(
    navigateToQR: () -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeUIState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect){
                is HomeEffectState.ShowToast -> { Toast.makeText(context, effect.message.message, Toast.LENGTH_SHORT).show() }
                is HomeEffectState.ShowSnackbar -> { /*onShowSnackbar(effect.message)*/ }
                is HomeEffectState.NavigateToQR -> navigateToQR()
            }
        }
    }

    HomeScreen(
        homeUiState = homeUIState,
        actionHandler = viewModel::setEvent,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    homeUiState: HomeUIState = HomeUIState.Loading,
    actionHandler: (HomeEventState) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text("hello")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
//        homeUiState = HomeUIState.Loading,
//        actionHandler = {}
    )
}