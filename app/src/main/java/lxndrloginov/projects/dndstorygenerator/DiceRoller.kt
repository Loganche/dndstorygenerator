package lxndrloginov.projects.dndstorygenerator

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lxndrloginov.projects.dndstorygenerator.data.Dice
import lxndrloginov.projects.dndstorygenerator.data.DiceData
import lxndrloginov.projects.dndstorygenerator.ui.theme.DndstorygeneratorappTheme

@OptIn(ExperimentalFoundationApi::class)
class DiceRoller : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DndstorygeneratorappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RollAllDices()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RollAllDices(dices: List<Dice> = DiceData.dices) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(dices) { dice ->
            RollDice(dice)
        }
    }
}


@Composable
fun RollDice(dice: Dice) {

    var diceResult by remember {
        mutableStateOf(dice.roll())
    }
    val diceSides by remember {
        mutableStateOf(dice.numSides)
    }
    val diceIcon by remember {
        mutableStateOf(dice.imageId)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                diceResult = dice.roll()
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = diceIcon),
                    contentDescription = "Dice Icon",
                    modifier = Modifier
                        .padding(12.dp)
                        .scale(1.5F)
                )

                Text(
                    text = "$diceSides sides",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }

            Text(
                text = "$diceResult",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
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
fun DiceRollerPreview() {
    DndstorygeneratorappTheme {
        RollDice(dice = Dice(6, R.drawable.d6))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun DicesRollerPreview() {
    DndstorygeneratorappTheme {
        RollAllDices()
    }
}