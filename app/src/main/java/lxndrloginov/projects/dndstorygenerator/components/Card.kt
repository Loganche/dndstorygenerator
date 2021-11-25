package lxndrloginov.projects.dndstorygenerator.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme


@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        content = content,
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
fun CardComponentPreview() {
    DndstorygeneratorappTheme {
        CardComponent( content = { Text(text = "Card Preview", modifier = Modifier.padding(16.dp)) } )
    }
}