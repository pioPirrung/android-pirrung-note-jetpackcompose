package de.pirrung.compose.notes.feature_notes.domain.use_case

import de.pirrung.compose.notes.feature_notes.domain.model.Note
import de.pirrung.compose.notes.feature_notes.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }

}