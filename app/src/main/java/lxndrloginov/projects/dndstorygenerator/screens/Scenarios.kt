package lxndrloginov.projects.dndstorygenerator.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.DelicateCoroutinesApi
import lxndrloginov.projects.dndstorygenerator.MainViewModel
import lxndrloginov.projects.dndstorygenerator.components.ButtonComponent
import lxndrloginov.projects.dndstorygenerator.components.LazyColumnComponent
import lxndrloginov.projects.dndstorygenerator.data.Story
import lxndrloginov.projects.dndstorygenerator.data.StorySampleData
import lxndrloginov.projects.dndstorygenerator.handler.RequestHandler


@DelicateCoroutinesApi
@Composable
fun ScenariosScreen(viewModel: MainViewModel) {
    val requests = RequestHandler()
    viewModel.setCurrentScreen(Screens.HomeScreens.Scenarios)
    Column() {
        LazyColumnComponent(
            content = { items(requests.outputs) { output -> Text(text = output) } },
        )
        ButtonComponent(
            content = { Text(text = "Generate") },
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val inputs = "The hero entered the spider cave."
                val story = Story(inputs)
                story.outputs = requests.run(inputs)
                StorySampleData.stories.add(story)
            })
    }
}