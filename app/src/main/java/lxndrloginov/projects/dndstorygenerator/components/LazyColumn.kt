package lxndrloginov.projects.dndstorygenerator.components

import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LazyColumnComponent(
    modifier: Modifier = Modifier,
    content: @ExtensionFunctionType LazyListScope.() -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        content = content,
    )
}