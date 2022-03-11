package de.pirrung.compose.notes.feature_notes.domain.use_case

import de.pirrung.compose.notes.feature_notes.domain.model.InvalidNoteException
import de.pirrung.compose.notes.feature_notes.domain.model.Note
import de.pirrung.compose.notes.feature_notes.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("the title of the note cant be empty")
        if (note.content.isBlank())
            throw InvalidNoteException("the content of the note cant be empty")

        repository.insertNote(note)
    }

}