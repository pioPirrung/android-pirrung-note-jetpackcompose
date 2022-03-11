package de.pirrung.compose.notes

import android.app.Application
import de.pirrung.compose.notes.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
//            androidLogger(Level.DEBUG)
            androidContext(this@NoteApp)
            modules(appModule)
//            modules(listOf(noteDatabaseModule, noteRepositoryModule, noteUseCasesModule, noteViewModelModule, addEditNoteViewModelModule))
        }
    }
}