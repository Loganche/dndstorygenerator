package lxndrloginov.projects.dndstorygenerator.screens

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lxndrloginov.projects.dndstorygenerator.data.Dice
import lxndrloginov.projects.dndstorygenerator.data.Story
import lxndrloginov.projects.dndstorygenerator.data.StorySampleData
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme

class StoryGenerator {
}


// Should add TextField
// and TextField Handler


@Composable
fun ListStories(stories: List<Story> = StorySampleData.stories) {
    LazyColumn() {
        items(stories) { story ->
            GenerateStory(story)
        }
    }
}


@Composable
fun GenerateStory(story: Story) {
    val generatedText by remember {
        mutableStateOf(story.generateText())
    }
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor: Color by animateColorAsState(
        if (isExpanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface,
    )

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        Surface(
            color = surfaceColor,
            modifier = Modifier
                .animateContentSize()
                .padding(4.dp)
        ) {
            Text(
                text = generatedText,
                maxLines = if (isExpanded) Int.MAX_VALUE else 2,
            )
        }
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
fun GenerateStoryPreview() {
    DndstorygeneratorappTheme {
        GenerateStory(story = Story("This is a string to generate a story."))
    }
}


@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun StoriesListPreview() {
    DndstorygeneratorappTheme {
        ListStories()
    }
}