package de.pirrung.compose.notes.feature_notes.domain.use_case

import de.pirrung.compose.notes.feature_notes.domain.model.Note
import de.pirrung.compose.notes.feature_notes.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}