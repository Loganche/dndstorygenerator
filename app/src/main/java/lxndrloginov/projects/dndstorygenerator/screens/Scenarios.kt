package lxndrloginov.projects.dndstorygenerator.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lxndrloginov.projects.dndstorygenerator.MainViewModel

@Composable
fun ScenariosScreen(viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.HomeScreens.Scenarios)
    Text(text = "Scenarios Screen")
}