package lxndrloginov.projects.dndstorygenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import lxndrloginov.projects.dndstorygenerator.components.AppScaffold
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DndstorygeneratorappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CompositionLocalProvider(LocalBackPressedDispatcher provides this.onBackPressedDispatcher) {
                        AppScaffold()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DndstorygeneratorappTheme {
        AppScaffold()
    }
}