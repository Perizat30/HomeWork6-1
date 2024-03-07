package com.example.homework6_1.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.homework6_1.databinding.ItemCharacterBinding
import com.example.homework6_1.data.model.Character

class CharactersAdapter:
    RecyclerView.Adapter<CharactersAdapter.MainViewHolder>() {

        private var characters = listOf<Character>()

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): MainViewHolder{
        return MainViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }
    fun setCharacters(list: List<Character>) {
        characters =list

    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int){
        val character = characters[position]
        holder.bind(character)
    }

    inner class MainViewHolder(private val binding: ItemCharacterBinding): ViewHolder(binding.root){
        fun bind(character : Character){
            binding.apply {
                tvCharacterName.text = character.name
                tvExistance.text = character.status
                tvSpecies.text = character.species
                tvLocationInfo.text = character.location.name
                Glide.with(imgCharacter).load(character.image).into(imgCharacter)
            }
        }
    }
}