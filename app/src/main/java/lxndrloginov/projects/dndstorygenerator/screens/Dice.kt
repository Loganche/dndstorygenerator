package lxndrloginov.projects.dndstorygenerator.screens

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lxndrloginov.projects.dndstorygenerator.MainViewModel
import lxndrloginov.projects.dndstorygenerator.R
import lxndrloginov.projects.dndstorygenerator.components.CardComponent
import lxndrloginov.projects.dndstorygenerator.components.LazyGridComponent
import lxndrloginov.projects.dndstorygenerator.data.Dice
import lxndrloginov.projects.dndstorygenerator.data.DiceData
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiceScreen(viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.HomeScreens.Dice)
    DiceGrid()
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiceGrid(dices: List<Dice> = DiceData.dices) {
    LazyGridComponent(
        numCells = 2,
        content = { items(dices) { dice -> DiceCard(dice) } },
    )
}


@Composable
fun DiceCard(dice: Dice) {

    var diceResult by remember { mutableStateOf(dice.roll()) }
    val diceSides by remember { mutableStateOf(dice.numSides) }
    val diceIcon by remember { mutableStateOf(dice.imageId) }

    CardComponent(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                diceResult = dice.roll()
            },
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically, ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally, ) {
                    Image(
                        painter = painterResource(id = diceIcon),
                        contentDescription = "Dice Icon",
                        modifier = Modifier
                            .padding(all = 12.dp)
                            .scale(1.5F)
                    )
                    Text(
                        text = "$diceSides sides",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium, )
                }

                Text(
                    text = "$diceResult",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left, )
            }
        },
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
fun DiceCardPreview() {
    DndstorygeneratorappTheme {
        DiceCard( dice = Dice(6, R.drawable.d6) )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun DiceGridPreview() {
    DndstorygeneratorappTheme {
        DiceGrid()
    }
}