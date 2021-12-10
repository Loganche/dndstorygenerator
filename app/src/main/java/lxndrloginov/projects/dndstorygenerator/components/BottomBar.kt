package lxndrloginov.projects.dndstorygenerator.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lxndrloginov.projects.dndstorygenerator.screens.Screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(modifier: Modifier = Modifier, screens: List<Screens.HomeScreens>, navController: NavController) {
    BottomNavigation(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = "") },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // 1 -> 2
                        // popUpTo = navController.graph.startDestination
                        navController.graph.startDestinationRoute?.let { popUpTo(it) }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}