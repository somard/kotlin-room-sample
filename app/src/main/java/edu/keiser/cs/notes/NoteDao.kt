package edu.keiser.cs.notes

import androidx.room.Dao
import androidx.room.Query

@Dao
interface NoteDao  {
    @Query("INSERT INTO notes (contents) VALUES('NEW note')")
    fun create()

    @Query("SELECT * FROM notes")
    fun getAllNotes():List<Note>

    @Query("UPDATE notes SET contents=:contents WHERE id=:id")
    fun save(contents: String, id:Int)

    @Query("DELETE FROM notes WHERE id =:id")
    fun deleteById(id:Int)

}