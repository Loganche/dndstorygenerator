package lxndrloginov.projects.dndstorygenerator

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import lxndrloginov.projects.dndstorygenerator.data.Dice
import lxndrloginov.projects.dndstorygenerator.data.Story
import lxndrloginov.projects.dndstorygenerator.data.StorySampleData
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme

class StoryGenerator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DndstorygeneratorappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}


@Composable
fun ListStories(stories: List<Story> = StorySampleData.stories) {
    LazyColumn(    ) {
        items(stories) { story ->
            GenerateStory(story)
        }
    }
}


@Composable
fun GenerateStory(story: Story){

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
fun StoriesListPreview(){
    DndstorygeneratorappTheme {
        ListStories()
    }
}