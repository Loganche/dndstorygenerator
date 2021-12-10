package lxndrloginov.projects.dndstorygenerator.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lxndrloginov.projects.dndstorygenerator.MainViewModel

@Composable
fun AboutScreen(viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.DrawerScreens.About)
    Text(text = "About Screen")
}