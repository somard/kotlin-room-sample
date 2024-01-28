package edu.keiser.cs.notes.model

import android.content.Context
import androidx.room.Room

object DatabaseInstance {

    fun getDB(context: Context) : NotesDatabase {
        return Room.databaseBuilder(context,
            NotesDatabase::class.java,
            "notes")
            .allowMainThreadQueries()
            .build()
    }
}