package de.pirrung.compose.notes.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import de.pirrung.compose.notes.feature_notes.data.data_source.NoteDao
import de.pirrung.compose.notes.feature_notes.data.data_source.NoteDatabase
import de.pirrung.compose.notes.feature_notes.data.repository.NoteRepositoryImpl
import de.pirrung.compose.notes.feature_notes.domain.repository.NoteRepository
import de.pirrung.compose.notes.feature_notes.domain.use_case.*
import de.pirrung.compose.notes.feature_notes.presentation.add_edit_note.AddEditNoteViewModel
import de.pirrung.compose.notes.feature_notes.presentation.notes.NotesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val appModule = module {
    single {
        providesDatabase(get())
    }

    single {
        providesDao(get())
    }

    single<NoteRepository> {
        NoteRepositoryImpl(get())
    }

    single {
        GetNotes(get())
    }

    single {
        DeleteNote(get())
    }

    single {
        AddNote(get())
    }

    single {
        GetNote(get())
    }

    single {
        NoteUseCases(get(), get(), get(), get())
    }

    viewModel {
        NotesViewModel(get())
    }

    viewModel {
        AddEditNoteViewModel(get(), get())
    }

}

fun providesDatabase(application: Application): NoteDatabase =
    Room.databaseBuilder(application, NoteDatabase::class.java,"userdatabase")
        .build()

fun providesDao(db: NoteDatabase): NoteDao = db.noteDao

//fun provideDatabase(context: Context): NoteDatabase {
//    return Room.databaseBuilder(
//        context,
//        NoteDatabase::class.java,
//        NoteDatabase.DATABASE_NAME
//    ).build()
//}

//val noteDatabaseModule = module {
//    single {
////        NoteDatabase
//        Room.databaseBuilder(
//            androidApplication(),
//            NoteDatabase::class.java,
//            NoteDatabase.DATABASE_NAME
//        ).build()
//    }
//}
//
//val noteRepositoryModule = module {
//    single {
//        NoteRepositoryImpl(get())
//    }
//}
//
//val noteUseCasesModule = module {
//    single {
//        NoteUseCases(get(), get(), get(), get())
//    }
//}
//
//val noteViewModelModule = module {
//    viewModel {
//        NotesViewModel(get())
//    }
//}
//
//val addEditNoteViewModelModule = module {
//    viewModel {
//        AddEditNoteViewModel(get(), get())
//    }
//}