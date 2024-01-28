package edu.keiser.cs.notes.control

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.keiser.cs.notes.view.NoteActivity
import edu.keiser.cs.notes.R
import edu.keiser.cs.notes.R.id.note_body
import edu.keiser.cs.notes.R.id.tv_note
import edu.keiser.cs.notes.model.Note
import edu.keiser.cs.notes.model.NotesDatabase

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var allNotes = mutableListOf<Note>()
    lateinit var db: NotesDatabase
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var notebody: LinearLayout = view.findViewById(note_body)
        init{
            notebody.setOnClickListener {
                var data = it.tag as Note
                var intent = Intent(view.context, NoteActivity::class.java)
                intent.putExtra("contents", data.contents)
                intent.putExtra("id", data.id)
                view.context.startActivity(intent)
            }
            notebody.setOnLongClickListener {
                var data = it.tag as Note
                db.noteDao().deleteById(data.id)
                reload(db)
                true
            }
        }
        fun onBind(note: Note) {
            notebody.tag = note
            view.findViewById<TextView>(tv_note).text = note.contents
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(allNotes[position])
    }

    fun reload(db: NotesDatabase) {
        this.db = db
        allNotes.clear()
        allNotes.addAll(db.noteDao().getAllNotes())
        notifyDataSetChanged()
    }
}