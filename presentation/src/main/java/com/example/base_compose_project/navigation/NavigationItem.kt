package com.example.base_compose_project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.base_compose_project.screen.home.navigation.homeRoute


sealed class NavigationItem(
    val title: Int,
    val outLineIcon: ImageVector,
    val fillIcon: ImageVector,
    val route: String
) {
    data object Home: NavigationItem(1, Icons.Outlined.Home, Icons.Filled.Home, homeRoute)

    companion object {
        fun toList(): List<NavigationItem>{
            return listOf(Home)
        }
    }
}