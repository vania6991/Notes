package ua.yaremchuk.notes.presentation.screens

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.databinding.FragmentEditNoteBinding
import ua.yaremchuk.notes.domain.Note
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    private val viewModel by viewModels<EditNoteViewModel>()

    private val args: EditNoteFragmentArgs by navArgs()

    private lateinit var binding: FragmentEditNoteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditNoteBinding.bind(view)

        val noteId = args.noteId
        viewModel.getNoteById(noteId)

        publishNoteFields()

        binding.fabSave.setOnClickListener {
            onClickSave()
        }
    }

    private fun publishNoteFields() {
        viewModel.currentNote.observe(viewLifecycleOwner) { note ->
            val textTitle = Editable.Factory.getInstance().newEditable(note.title)
            val textDescription = Editable.Factory.getInstance().newEditable(note.description)
            binding.editTitle.text = textTitle
            if (note.description != "") {
                binding.editDescription.text = textDescription
            }
        }
    }

    private fun onClickSave() {
        val noteId = args.noteId
        val formatter = SimpleDateFormat.getDateTimeInstance()
        val note = Note(
            id = noteId,
            title = binding.editTitle.text.toString(),
            description = binding.editDescription.text.toString(),
            date = formatter.format(Date())
        )
        val title = binding.editTitle.text.toString()
        val description = binding.editDescription.text.toString()
        Log.i("MY_APP", "onClickSave: $title, $description")
        viewModel.updateNote(note)
        findNavController().popBackStack()
    }


}