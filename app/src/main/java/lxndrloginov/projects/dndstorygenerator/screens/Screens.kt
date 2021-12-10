package lxndrloginov.projects.dndstorygenerator.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val title: String) {

    sealed class HomeScreens(
        route: String,
        title: String,
        val icon: ImageVector
    ) : Screens(
        route,
        title
    ) {
        object Dice : HomeScreens("dice", "Dice", Icons.Filled.Casino)
        object Story : HomeScreens("story", "Story", Icons.Filled.Article)
        object Scenarios : HomeScreens("scenarios", "Scenarios", Icons.Filled.MenuBook)
    }

    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Profile : DrawerScreens("profile", "Profile")
        object About : DrawerScreens("about", "About")
    }
}

val screensInHomeFromBottomNav = listOf(
    Screens.HomeScreens.Dice,
    Screens.HomeScreens.Story,
    Screens.HomeScreens.Scenarios
)

// Delete Later
val screensFromDrawer = listOf(
    Screens.DrawerScreens.Profile,
    Screens.DrawerScreens.About,
)