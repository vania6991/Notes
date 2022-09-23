package ua.yaremchuk.notes.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes order by id DESC")
    fun getAllNotes(): Flow<List<NoteDbEntity>?>

    @Insert(entity = NoteDbEntity::class)
    suspend fun addNote(note: NoteDbEntity)

    @Update(entity = NoteDbEntity::class)
    suspend fun updateNote(note: NoteDbEntity)

    @Query("DELETE FROM notes WHERE notes.id = :noteId")
    suspend fun deleteNote(noteId: Int)
}