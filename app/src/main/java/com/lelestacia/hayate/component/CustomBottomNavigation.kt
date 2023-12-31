package com.lelestacia.hayate.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.lelestacia.hayate.common.theme.quickSandFamily
import com.lelestacia.hayate.domain.state.BottomNavigationState

@Composable
fun CustomBottomNavigation(
    navController: NavHostController,
    uiController: SystemUiController,
    state: BottomNavigationState
) {
    val bottomNavigationColor = MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp)
    val surfaceColor = MaterialTheme.colorScheme.surface

    SideEffect {
        if (state.isRootDestination) {
            uiController.setNavigationBarColor(
                color = bottomNavigationColor,
                darkIcons = !state.isDarkTheme
            )
        } else {
            uiController.setNavigationBarColor(
                color = surfaceColor,
                darkIcons = !state.isDarkTheme
            )
        }
    }

    //  TODO: Fix Coloring for Night Mode
    AnimatedVisibility(
        visible = state.isRootDestination,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(250) // adjust duration as needed
        ) + fadeIn(animationSpec = tween(250)), // adjust duration as needed
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(250) // adjust duration as needed
        ) + fadeOut(animationSpec = tween(250)) // adjust duration as needed
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background
        ) {
            state.navigationItem.forEach { item ->
                NavigationBarItem(
                    selected = state.selectedRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(id = navController.graph.startDestinationId) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        AnimatedContent(
                            targetState = state.selectedRoute == item.route,
                            label = "Icon Animation"
                        ) { selected ->
                            when (selected) {
                                true -> {
                                    Icon(
                                        imageVector = item.selectedIcon,
                                        contentDescription = stringResource(id = item.title)
                                    )
                                }

                                false -> {
                                    Icon(
                                        imageVector = item.unselectedIcon,
                                        contentDescription = stringResource(id = item.title)
                                    )
                                }
                            }
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontFamily = quickSandFamily
                            )
                        )
                    },
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor =
                        when (state.isDarkTheme) {
                            true -> Color.White.copy(
                                alpha = 0.75F
                            )

                            false -> MaterialTheme.colorScheme.primary
                        },
                        selectedIconColor =
                        when (state.isDarkTheme) {
                            true -> Color.White
                            false -> Color.White
                        },
                        indicatorColor =
                        when (state.isDarkTheme) {
                            true -> MaterialTheme.colorScheme.primaryContainer
                            false -> MaterialTheme.colorScheme.primary
                        },
                        selectedTextColor =
                        when (state.isDarkTheme) {
                            true -> Color.White
                            false -> MaterialTheme.colorScheme.primary
                        }
                    )
                )
            }
        }
    }
}