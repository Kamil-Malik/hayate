package com.lelestacia.hayate.domain.state

import com.lelestacia.hayate.common.shared.Screen
import com.lelestacia.hayate.navigation.CustomNavigationItem
import com.lelestacia.hayate.navigation.HayateNavigationItem

data class BottomNavigationState(
    val isDarkTheme: Boolean = false,
    val selectedRoute: String = Screen.Exploration.route,
    val isRootDestination: Boolean = true,
    val navigationItem: List<CustomNavigationItem> = HayateNavigationItem
)
