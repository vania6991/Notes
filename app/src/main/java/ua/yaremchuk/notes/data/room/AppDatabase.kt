package ua.yaremchuk.notes.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        NoteDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
}