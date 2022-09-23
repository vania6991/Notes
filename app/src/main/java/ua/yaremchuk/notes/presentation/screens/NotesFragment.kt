package ua.yaremchuk.notes.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.databinding.FragmentNotesBinding
import ua.yaremchuk.notes.domain.Note
import ua.yaremchuk.notes.presentation.adapter.NotesAdapter
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class NotesFragment() : Fragment(R.layout.fragment_notes), NotesAdapter.NoteActionListener {

    private lateinit var viewModel: SharedViewModel

    private lateinit var binding: FragmentNotesBinding
    private lateinit var adapter: NotesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        adapter = NotesAdapter()

        adapter.noteActionListener = this

        val layoutManager = LinearLayoutManager(context)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


        viewModel.notesList.observe(viewLifecycleOwner) {
            it?.let { adapter.note = it }
        }

        binding.fab.setOnClickListener {
            onAddNoteButtonPressed()
        }
    }

    private fun onAddNoteButtonPressed() {
        val formatter = SimpleDateFormat.getDateTimeInstance()

        val note = Note(
            title = getString(R.string.new_note),
            date = formatter.format(Date())
        )
        viewModel.addNewNote(note)
    }

    override fun onOpenEditNote(note: Note) {
        findNavController().navigate(R.id.action_notesFragment_to_editNoteFragment)
    }
}