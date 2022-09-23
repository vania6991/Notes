package ua.yaremchuk.notes.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.yaremchuk.notes.databinding.ItemNoteBinding
import ua.yaremchuk.notes.domain.Note

class NotesAdapter() :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    var note: List<Note> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    var noteActionListener: NoteActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)


        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = note[position]
        with(holder.binding) {
            title.text = note.title
            description.text = note.description
            date.text = note.date
            holder.itemView.tag = note

            root.setOnClickListener {
                noteActionListener?.onOpenEditNote(note)
            }
        }
    }

    override fun getItemCount(): Int = note.size

    class NotesViewHolder(
        val binding: ItemNoteBinding
    ) : RecyclerView.ViewHolder(binding.root)

    interface NoteActionListener {

        fun onOpenEditNote(note: Note)

    }

}