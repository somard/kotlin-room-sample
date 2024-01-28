package edu.keiser.cs.notes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.keiser.cs.notes.R
import edu.keiser.cs.notes.model.DatabaseInstance
import edu.keiser.cs.notes.control.NoteAdapter
import edu.keiser.cs.notes.model.NotesDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var db: NotesDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseInstance.getDB(this)

        recyclerView = findViewById(R.id.rv_notes)

        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(RecyclerViewDecorator(16))

        findViewById<FloatingActionButton>(R.id.btn_add_note).setOnClickListener {
            db.noteDao().create()
            adapter.reload(db)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.reload(db)
    }
}