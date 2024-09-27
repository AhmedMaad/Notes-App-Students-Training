package com.maad.notesapptraining.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maad.notesapptraining.AddingNoteScreen
import com.maad.notesapptraining.EditingNoteScreen
import com.maad.notesapptraining.HomeScreen
import com.maad.notesapptraining.routes.Route.ADD_NOTE
import com.maad.notesapptraining.routes.Route.EDIT_NOTE
import com.maad.notesapptraining.routes.Route.HOME

object Route {
    const val HOME = "home"
    const val ADD_NOTE = "add_note"
    const val EDIT_NOTE = "edit_note"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) { HomeScreen(navController = navController) }
        composable(route = ADD_NOTE) { AddingNoteScreen(navController = navController) }
        //According to the docs: You cannot pass complex data using parcelable
        //https://developer.android.com/guide/navigation/use-graph/pass-data
        composable(
            route = "$EDIT_NOTE/{id}/{details}?title={title}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType},
                navArgument("details") { type = NavType.StringType},
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val id = it.arguments?.getInt("id")!!
            val details = it.arguments?.getString("details")!!
            val title = it.arguments?.getString("title")!!
            EditingNoteScreen(id, details, title, navController = navController)
        }

    }

}