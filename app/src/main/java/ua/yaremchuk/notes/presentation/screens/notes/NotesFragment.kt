package ua.yaremchuk.notes.presentation.screens.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.databinding.FragmentNotesBinding

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val viewModel by viewModels<NotesViewModel>()

    private lateinit var binding: FragmentNotesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)

    }
}