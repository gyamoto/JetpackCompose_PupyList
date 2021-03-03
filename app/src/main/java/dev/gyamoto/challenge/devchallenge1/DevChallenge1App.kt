package dev.gyamoto.challenge.devchallenge1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import dev.gyamoto.challenge.devchallenge1.ui.theme.DevChallenge1Theme

@Composable
fun DevChallenge1App() {

    val navController = rememberNavController()

    DevChallenge1Theme {
        NavHost(
            navController = navController,
            startDestination = "pupy/list"
        ) {
            composable(route = "pupy/list") {
                PupyList(
                    onClickPupy = {
                        navController.navigate("pupy/detail/$it")
                    }
                )
            }
            composable(route = "pupy/detail/{id}") {
                val id = it.arguments?.getString("id") ?: return@composable
                PupyDetail(id)
            }
        }
    }
}