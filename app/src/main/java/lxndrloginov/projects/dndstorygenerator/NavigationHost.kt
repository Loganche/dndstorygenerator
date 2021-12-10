package lxndrloginov.projects.dndstorygenerator

import android.accounts.Account
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import lxndrloginov.projects.dndstorygenerator.screens.*



@Composable
fun NavigationHost(navController: NavController, viewModel: MainViewModel) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.DrawerScreens.About.route
    ) {
            composable(Screens.DrawerScreens.About.route) { AboutScreen(viewModel = viewModel) }
            composable(Screens.HomeScreens.Story.route) { StoryScreen(viewModel = viewModel) }
            composable(Screens.HomeScreens.Dice.route) { DiceScreen(viewModel = viewModel) }
            composable(Screens.HomeScreens.Scenarios.route) { ScenariosScreen(viewModel = viewModel) }
            composable(Screens.DrawerScreens.Profile.route) { ProfileScreen(viewModel = viewModel) }

    }
}