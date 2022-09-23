package ua.yaremchuk.notes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.yaremchuk.notes.data.room.RoomNotesRepository
import ua.yaremchuk.notes.data.NotesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class NotesRepositoryModule {

    @Binds
    abstract fun bindNotesRepository(
        notesRepository: RoomNotesRepository
    ): NotesRepository
}