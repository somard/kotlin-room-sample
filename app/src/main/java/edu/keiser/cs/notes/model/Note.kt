package edu.keiser.cs.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="notes")
data class Note(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "contents") val contents: String
)
