package lxndrloginov.projects.dndstorygenerator.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import lxndrloginov.projects.dndstorygenerator.BackPressHandler
import lxndrloginov.projects.dndstorygenerator.MainViewModel
import lxndrloginov.projects.dndstorygenerator.NavigationHost
import lxndrloginov.projects.dndstorygenerator.screens.Screens
import lxndrloginov.projects.dndstorygenerator.screens.screensInHomeFromBottomNav
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme


@Composable
fun AppScaffold() {
    val viewModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentScreen by viewModel.currentScreen.observeAsState()

    if (scaffoldState.drawerState.isOpen) {
        BackPressHandler {
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }

    var topBar : @Composable () -> Unit = {
        TopBar(
            title = currentScreen!!.title,
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        )
    }
    if (currentScreen == Screens.DrawerScreens.About) {
        topBar = {
            TopBar(
                title = Screens.DrawerScreens.About.title,
                buttonIcon = Icons.Filled.ArrowBack,
                onButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }

    val bottomBar: @Composable () -> Unit = {
        if (currentScreen is Screens.DrawerScreens || currentScreen is Screens.HomeScreens) {
            BottomBar(
                navController = navController,
                screens = screensInHomeFromBottomNav
            )
        }
    }

    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer { route ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(route) {
                    navController.graph.startDestinationRoute?.let { popUpTo(it) }
                    launchSingleTop = true
                }
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) { innerPadding ->
        NavigationHost(navController = navController, viewModel = viewModel)
    }
}


@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun ScaffoldFragmentPreview() {
    DndstorygeneratorappTheme {
        AppScaffold()
    }
}