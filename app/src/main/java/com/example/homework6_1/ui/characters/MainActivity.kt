package com.example.homework6_1.ui.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework6_1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<MainViewModel> ()

    private val charactersAdapter by lazy{CharactersAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()

        viewModel.getCharacters().observe(this){
            charactersAdapter.setCharacters(it)
        }
    }
    private fun setupRecycler() = with(binding.recyclerView){
        adapter = charactersAdapter
        layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)

    }
}