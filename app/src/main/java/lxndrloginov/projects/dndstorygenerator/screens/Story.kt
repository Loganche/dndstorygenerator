package lxndrloginov.projects.dndstorygenerator.screens

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lxndrloginov.projects.dndstorygenerator.components.*
import lxndrloginov.projects.dndstorygenerator.data.Story
import lxndrloginov.projects.dndstorygenerator.data.StorySampleData
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme

/*
TODO
Make Stories, TextField and Button be at the bottom
Make handler TextField -> Button -> backend
Make handler backend -> Story -> Show Story

Design of Button, TextField in components
 */


@Composable
fun StoryScreen() {
    ScaffoldComponent(
        content = {
            val inputSentence = remember { mutableStateOf("") }

            Column( verticalArrangement = Arrangement.Bottom ) {
                StoryColumn()
                TextFieldComponent(
                    value = inputSentence.value,
                    onValueChange = { newText -> inputSentence.value = newText },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                ButtonComponent(
                    onClick = { },
                    content = { Text(text = "Generate") },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
        },
    )
}

@Composable
fun StoryColumn(stories: List<Story> = StorySampleData.stories) {
    LazyColumnComponent(
        content = { items(stories) { story -> StoryCard(story) } },
    )
}


@Composable
fun StoryCard(story: Story) {
    val generatedText by remember { mutableStateOf(story.generateText()) }
    var isExpanded by remember { mutableStateOf(false) }


    CardComponent(
        modifier = Modifier
            .padding(4.dp)
            .clickable { isExpanded = !isExpanded },
        content = {
            Surface(
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
fun StoryCardPreview() {
    DndstorygeneratorappTheme {
        StoryCard(story = Story("This is a string to generate a story."))
    }
}


@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun StoryColumnPreview() {
    DndstorygeneratorappTheme {
        StoryColumn()
    }
}