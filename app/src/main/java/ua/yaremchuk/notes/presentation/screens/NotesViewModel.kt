package ua.yaremchuk.notes.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.yaremchuk.notes.R
import ua.yaremchuk.notes.data.NotesRepository
import ua.yaremchuk.notes.domain.Note
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {

    private val _notesList = MutableLiveData<List<Note>>()
    val notesList: LiveData<List<Note>?> = _notesList

    private val titleLiveData = MutableLiveData(R.string.new_note.toString())
    var title: String?
        get() = titleLiveData.value
        set(value) {
            titleLiveData.value = value
        }

    private val descriptionLiveData = MutableLiveData("")
    var description: String?
        get() = descriptionLiveData.value
        set(value) {
            descriptionLiveData.value = value
        }

    init {
        viewModelScope.launch {
            notesRepository.getAllNotes().collect {
                Log.i("MY_APP", "Notes: $it")
                _notesList.postValue(it)
            }
        }
    }

    fun addNewNote(note: Note) {
        viewModelScope.launch {
            notesRepository.setNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.update(note)
        }
    }

}