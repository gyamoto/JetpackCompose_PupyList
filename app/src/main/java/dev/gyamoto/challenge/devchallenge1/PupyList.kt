package dev.gyamoto.challenge.devchallenge1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.gyamoto.challenge.devchallenge1.ui.theme.DevChallenge1Theme

@Composable
fun PupyList(
    onClickPupy: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pupy")
                }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            PupyListContent(onClickPupy)
        }
    }
}

@Composable
private fun PupyListContent(
    onClickPupy: (String) -> Unit
) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        val pupies = PupyData.list
        items(pupies.size) {
            val pupy = pupies[it]
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
                    .clip(
                        shape = CutCornerShape(
                            topStart = 16.dp,
                            bottomEnd = 16.dp,
                        )
                    )
                    .clickable { onClickPupy(pupy.id) },
                elevation = 8.dp
            ) {
                ListItem(pupy)
            }
        }
    }
}

@Composable
private fun ListItem(pupy: Pupy) {

    val typography = MaterialTheme.typography

    Column(
        Modifier.background(Color.Gray.copy(alpha = 0.1f))
    ) {
        CoilImage(
            data = pupy.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            pupy.name,
            style = typography.h6,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevChallenge1Theme {
        PupyList(onClickPupy = {})
    }
}
