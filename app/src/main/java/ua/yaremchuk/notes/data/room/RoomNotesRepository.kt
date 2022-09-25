package ua.yaremchuk.notes.data.room

import kotlinx.coroutines.flow.*
import ua.yaremchuk.notes.data.NotesRepository
import ua.yaremchuk.notes.domain.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomNotesRepository @Inject constructor(
    private val noteDao: NoteDao
) : NotesRepository {

    override fun getAllNotes(): Flow<List<Note>?> {
        return noteDao.getAllNotes().map { listNoteDbEntity ->
            listNoteDbEntity?.map { it.toNote() }
        }
    }

    override suspend fun setNote(note: Note) {
        val entity = NoteDbEntity.fromNote(note)
        noteDao.addNote(entity)
    }

    override suspend fun removeNote(noteId: Int) {
        noteDao.deleteNote(noteId)

    }

    override suspend fun update(note: Note) {
        val entity = NoteDbEntity.fromNote(note)
        noteDao.updateNote(entity)
    }

    override fun getNoteById(noteId: Int): Flow<Note> {
        return noteDao.getById(noteId).map { it.toNote() }
    }
}