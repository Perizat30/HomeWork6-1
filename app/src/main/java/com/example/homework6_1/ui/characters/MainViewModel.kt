package com.example.homework6_1.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homework6_1.data.Repository
import com.example.homework6_1.data.model.Character
import com.example.homework6_1.data.model.CharactersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getCharacters():LiveData<CharactersResponse> = repository.getCharacters()
}