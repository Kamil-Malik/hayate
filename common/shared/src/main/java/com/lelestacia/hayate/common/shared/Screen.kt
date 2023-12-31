package com.lelestacia.hayate.common.shared

sealed class Screen(val route: String) {
    data object Exploration : Screen("explore")
    data object Collection : Screen("collection")
    data object More : Screen("more")
    data object Detail : Screen("anime/{data}") {
        fun createRoute(jsonAnime: String): String {
            return this.route.replace(
                oldValue = "{data}",
                newValue = jsonAnime
            )
        }
    }
}