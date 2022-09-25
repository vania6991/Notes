package ua.yaremchuk.notes.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ua.yaremchuk.notes.data.NotesRepository
import ua.yaremchuk.notes.domain.Note
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {

    private val _currentNote = MutableLiveData<Note>()
    val currentNote: LiveData<Note> = _currentNote

    fun getNoteById(id: Int) {
        viewModelScope.launch {
            notesRepository.getNoteById(id).collect {
                Log.i("MY_APP", "Note: $it")
                _currentNote.postValue(it)
            }
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            notesRepository.update(note)
        }
    }

}