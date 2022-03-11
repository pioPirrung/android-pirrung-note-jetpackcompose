package de.pirrung.compose.notes.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.pirrung.compose.notes.ui.theme.LightBlue
import de.pirrung.compose.notes.ui.theme.LightGreen
import de.pirrung.compose.notes.ui.theme.LightPurple
import de.pirrung.compose.notes.ui.theme.RedOrange
import java.lang.Exception

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {

    companion object {
        val noteColors = listOf(RedOrange, LightGreen, LightBlue, LightPurple)
    }

}

class InvalidNoteException(message: String): Exception(message)
