package com.cutech.importantcomponents.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cutech.importantcomponents.screens.DashboardScreen
import com.cutech.importantcomponents.screens.HomeScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues,
    showCustomSnackBar: (Boolean, String) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoute.HomeScreen,
        modifier = Modifier.padding(innerPaddingValues)
    ) {

        composable<NavRoute.HomeScreen>{
            HomeScreen(
                onClick = {
                    navHostController.navigate(NavRoute.DashboardScreen)
                },
                showToast = {
                    showCustomSnackBar(true, "Click from Home Screen")
                }
            )
        }

        composable<NavRoute.DashboardScreen>{
            DashboardScreen(
                onClick = {
                    navHostController.navigate(NavRoute.HomeScreen)
                },
                showToast = {
                    showCustomSnackBar(true, "Click from Dashboard Screen")
                }
            )
        }

    }

}