package edu.keiser.cs.notes.model

import androidx.room.Dao
import androidx.room.Query
import edu.keiser.cs.notes.model.Note

@Dao
interface NoteDao  {
    @Query("INSERT INTO notes (contents) VALUES('default note')")
    fun create()

    @Query("SELECT * FROM notes")
    fun getAllNotes():List<Note>

    @Query("UPDATE notes SET contents=:contents WHERE id=:id")
    fun save(contents: String, id:Int)

    @Query("DELETE FROM notes WHERE id =:id")
    fun deleteById(id:Int)

}