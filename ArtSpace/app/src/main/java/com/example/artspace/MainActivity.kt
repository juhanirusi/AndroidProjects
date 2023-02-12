package com.example.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ShowcaseArtScreen()
                }
            }
        }
    }
}

@Composable
fun ShowcaseArtScreen() {
    var currentPaintingIndex by remember { mutableStateOf(0) }

    val paintingsList = listOf<Painting>(
        Painting(
            R.drawable.painting_1,
            stringResource(id = R.string.masterpiece),
            "Master Splinter"
        ),
        Painting(
            R.drawable.painting_2,
            stringResource(id = R.string.black_and_white_woman),
            "Walter White"
        ),
        Painting(
            R.drawable.painting_3,
            stringResource(id = R.string.flowers),
            "Flora Florist"
        ),
        Painting(
            R.drawable.painting_4,
            stringResource(id = R.string.two_horses),
            "Roxy Rider"
        ),
        Painting(
            R.drawable.painting_5,
            stringResource(id = R.string.a_huge_mess),
            "Missy Mess"
        ),
        Painting(
            R.drawable.painting_6,
            stringResource(id = R.string.singing_birds),
            "Billy Birdwatcher"
        ),
        Painting(
            R.drawable.painting_7,
            stringResource(id = R.string.cottages_mountain),
            "Summer Cottage"
        ),
        Painting(
            R.drawable.painting_8,
            stringResource(id = R.string.color_mess),
            "Milly Mess"
        )
    )

    if (currentPaintingIndex > (paintingsList.size - 1)) {
        currentPaintingIndex = 0
    } else if (currentPaintingIndex < 0) {
        currentPaintingIndex = (paintingsList.size - 1)
    }

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        PaintingImage(currentPaintingIndex, paintingsList)
        //Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.wrapContentHeight()) {
            PaintingAndArtistInfo(currentPaintingIndex, paintingsList)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { currentPaintingIndex-- },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp)) {
                    Text(text = stringResource(id = R.string.previous))
                }
                Button(
                    onClick = { currentPaintingIndex++ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp)) {
                    Text(text = stringResource(id = R.string.next))
                }
            }
        }
    }
}

@Composable
private fun PaintingImage(
    currentPaintingIndex: Int,
    paintings: List<Painting>,
) {
    Image(
        painter = painterResource(id = paintings[currentPaintingIndex].paintingImage),
        contentDescription = paintings[currentPaintingIndex].paintingName,
        Modifier
            .padding(horizontal = 25.dp)
            .padding(top = 40.dp)
            .border(width = 3.dp, color = Color.DarkGray)
            .padding(35.dp)
    )
}

@Composable
fun PaintingAndArtistInfo(
    currentPaintingIndex: Int,
    paintings: List<Painting>
) {
    Card(modifier = Modifier.padding(10.dp), elevation = 10.dp) {
        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()) {
            Text(text = paintings[currentPaintingIndex].paintingName,
                fontSize = 28.sp,
                fontWeight = FontWeight.Light)
            Text(text = paintings[currentPaintingIndex].artist, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ShowcaseArtScreen()
    }
}
