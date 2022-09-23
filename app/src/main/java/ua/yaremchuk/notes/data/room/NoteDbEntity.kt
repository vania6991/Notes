package ua.yaremchuk.notes.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.yaremchuk.notes.domain.Note

@Entity(tableName = "notes")
data class NoteDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: String
) {

    fun toNote(): Note = Note(
        id = id,
        title = title,
        description = description,
        date = date
    )

    companion object {
        fun fromNote(note: Note): NoteDbEntity {
            return NoteDbEntity(
                title = note.title,
                description = note.description,
                date = note.date
            )
        }
    }
}
