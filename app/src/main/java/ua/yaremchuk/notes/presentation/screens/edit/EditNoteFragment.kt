package ua.yaremchuk.notes.presentation.screens.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.databinding.FragmentEditNoteBinding

class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    private val viewModel by viewModels<EditNoteViewModel>()

    private lateinit var binding: FragmentEditNoteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditNoteBinding.bind(view)

    }

}