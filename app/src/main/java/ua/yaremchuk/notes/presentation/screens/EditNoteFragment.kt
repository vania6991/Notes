package ua.yaremchuk.notes.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.databinding.FragmentEditNoteBinding

class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    private lateinit var viewModel: SharedViewModel

    private lateinit var binding: FragmentEditNoteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditNoteBinding.bind(view)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

    }

}