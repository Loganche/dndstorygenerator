package lxndrloginov.projects.dndstorygenerator.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme


@Composable
fun ScaffoldComponent(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var isExpanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        content = content,
        scaffoldState = scaffoldState,
        drawerContent = {
            Column(verticalArrangement = Arrangement.Top) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                ) {
                    Icon(Icons.Filled.Person, contentDescription = "User Profile Screen")
                    Text(text = "Profile")
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                ) {
                    Icon(Icons.Filled.Info, contentDescription = "Additional Info Screen")
                    Text(text = "About")
                }
            }
        },
        topBar = {
            TopAppBar {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                ) {
                    IconButton(onClick = {
                        when (isExpanded) {
                            true -> scope.launch { scaffoldState.drawerState.close() }
                            false -> scope.launch { scaffoldState.drawerState.open() }
                        }
                    }) { Icon(Icons.Filled.Menu, contentDescription = "Drawer Menu") }
                }
            }
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                ) {
                    IconButton(onClick = { }) { Icon(Icons.Filled.Casino, contentDescription = "Dices Screen") }
                    IconButton(onClick = { }) { Icon(Icons.Filled.Article, contentDescription = "Story Screen") }
                    IconButton(onClick = { }) { Icon(Icons.Filled.MenuBook, contentDescription = "Scenarios Screen") }
                }
            }
        }
    )
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
        ScaffoldComponent(content = { Text(text = "Scaffold Preview.") })
    }
}