package com.cutech.importantcomponents.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoute {

    @Serializable
    data object HomeScreen: NavRoute

    @Serializable
    data object DashboardScreen: NavRoute
}