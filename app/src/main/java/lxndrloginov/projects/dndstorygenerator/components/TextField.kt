package lxndrloginov.projects.dndstorygenerator.components

import android.content.res.Configuration
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme


@Composable
fun TextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val inputSentence = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        label = { Text(text = "Write first sentence") },
        placeholder = { Text(text = "The Great Hero entered in the Tavern.") },
        interactionSource = interactionSource,
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
fun TextFieldComponentPreview(){
    DndstorygeneratorappTheme {
        TextFieldComponent( value = "", onValueChange = {}, )
    }
}