package lxndrloginov.projects.dndstorygenerator.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridComponent(
    modifier: Modifier = Modifier,
    numCells: Int,
    content: @ExtensionFunctionType LazyGridScope.() -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier,
        cells = GridCells.Fixed(numCells),
        content = content,
    )
}