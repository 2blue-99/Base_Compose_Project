package com.example.base_compose_project.screen.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.base_compose_project.screen.home.screen.HomeRoute

const val homeRoute = "home"
fun NavController.navigateToHome(navOptions: NavOptions? = null){
    this.navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
//    navigateToQR: () -> Unit,
    modifier: Modifier
){
    composable(
        route = homeRoute,
    ) {
        HomeRoute(
            {},
            modifier
        )
    }
}