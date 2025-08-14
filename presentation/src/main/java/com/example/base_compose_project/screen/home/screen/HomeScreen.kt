package com.example.base_compose_project.screen.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.base_compose_project.screen.home.HomeViewModel

@Composable
fun HomeRoute(
    navigateToQR: () -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
//    val context = LocalContext.current
//    val homeUiState by viewModel.homeUIState.collectAsStateWithLifecycle()
//    val spinnerDialogState by viewModel.spinnerDialogState.collectAsStateWithLifecycle()
//
//    LaunchedEffect(Unit) {
//        viewModel.sideEffectState.collect { effect ->
//            when(effect){
//                is HomeEffectState.ShowToast -> { Toast.makeText(context, effect.message.message, Toast.LENGTH_SHORT).show() }
//                is HomeEffectState.ShowSnackbar -> { /*onShowSnackbar(effect.message)*/ }
//                is HomeEffectState.NavigateToQR -> navigateToQR()
//                is HomeEffectState.NavigateToSetting -> { navigateToSetting() }
//                is HomeEffectState.NavigateToRandom -> navigateToRandom()
//                is HomeEffectState.NavigateToRecode -> navigateToRecode()
//                is HomeEffectState.NavigateToStatistic -> navigateToStatistic()
//                else -> {}
//            }
//        }
//    }

    HomeScreen(
//        homeUiState = homeUiState,
//        spinnerDialogState = spinnerDialogState,
//        actionHandler = viewModel::actionHandler,
//        effectHandler = viewModel::effectHandler,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
//    homeUiState: HomeUIState = HomeUIState.Loading,
//    spinnerDialogState: BaseDialogState<RoundSpinner> = BaseDialogState.Hide,
//    actionHandler: (HomeActionState) -> Unit = {},
//    effectHandler: (HomeEffectState) -> Unit = {},
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