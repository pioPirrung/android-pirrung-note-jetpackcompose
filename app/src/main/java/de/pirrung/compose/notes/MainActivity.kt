package de.pirrung.compose.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import de.pirrung.compose.notes.feature_notes.presentation.add_edit_note.AddEditNoteScreen
import de.pirrung.compose.notes.feature_notes.presentation.add_edit_note.AddEditNoteViewModel
import de.pirrung.compose.notes.feature_notes.presentation.notes.NotesScreen
import de.pirrung.compose.notes.feature_notes.presentation.notes.NotesViewModel
import de.pirrung.compose.notes.feature_notes.presentation.util.Screen
import de.pirrung.compose.notes.ui.theme.ComposenotesTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

//    private val notesViewModel by viewModel<NotesViewModel>()
//    private val addEditNoteViewModel by viewModel<AddEditNoteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notesViewModel by viewModel<NotesViewModel>()
        val addEditNoteViewModel by viewModel<AddEditNoteViewModel>()

        setContent {
            ComposenotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController = navController, viewModel = notesViewModel)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            AddEditNoteScreen(navController = navController, noteColor = it.arguments?.getInt("noteColor") ?: -1, viewModel = addEditNoteViewModel)
                        }
                    }
                }
            }
        }
    }
}
