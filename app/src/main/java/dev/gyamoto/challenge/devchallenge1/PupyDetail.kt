package dev.gyamoto.challenge.devchallenge1

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PupyDetail(id: String) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            val pupy = PupyData.list.find { it.id == id } ?: return@Scaffold
            DetailContent(pupy)
        }
    }
}

@Composable
private fun DetailContent(pupy: Pupy) {

    val typography = MaterialTheme.typography

    Column(
        Modifier.fillMaxWidth()
    ) {
        CoilImage(
            data = pupy.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(ratio = 1 / 1f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Box(Modifier.padding(16.dp)) {
            Column {
                Text(
                    pupy.name,
                    style = typography.h6,
                )
                Spacer(modifier = Modifier.requiredHeight(8.dp))
                Text(
                    pupy.address,
                    style = typography.body2,
                )
                Text(
                    pupy.birthday,
                    style = typography.body2,
                )
            }
        }
    }
}