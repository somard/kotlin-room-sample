package edu.keiser.cs.notes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

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