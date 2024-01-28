package edu.keiser.cs.notes.model

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.keiser.cs.notes.model.Note
import edu.keiser.cs.notes.model.NoteDao

@Database(entities =[Note::class], version=1)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}