package ua.yaremchuk.notes.data

import kotlinx.coroutines.flow.Flow
import ua.yaremchuk.notes.domain.Note

interface NotesRepository {

    fun getAllNotes(): Flow<List<Note>?>

    suspend fun setNote(note: Note)

    suspend fun removeNote(noteId: Int)

    suspend fun update(note: Note)
}