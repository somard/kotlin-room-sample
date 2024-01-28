package edu.keiser.cs.notes.view

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import edu.keiser.cs.notes.R
import edu.keiser.cs.notes.model.DatabaseInstance
import edu.keiser.cs.notes.model.NotesDatabase

class NoteActivity : AppCompatActivity() {
    private lateinit var db: NotesDatabase
    private var contents = ""
    private var id = 0
    private lateinit var editContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        contents = intent.getStringExtra("contents") ?: ""
        id = intent.getIntExtra("id", 0)

        editContent = findViewById(R.id.edit_text_note)
        editContent.setText(contents)

        db = DatabaseInstance.getDB(this)
    }


    override fun onPause() {
        super.onPause()
        db.noteDao().save(editContent.text.toString(), id)
    }
}