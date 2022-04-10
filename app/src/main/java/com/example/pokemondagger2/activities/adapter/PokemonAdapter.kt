package com.example.pokemondagger2.activities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondagger2.R
import com.example.pokemondagger2.data.response.Pokemon
import com.example.pokemondagger2.databinding.ItemPokemonNameBinding

class PokemonAdapter(private val pokemonNamesList: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPokemonNameBinding = ItemPokemonNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = pokemonNamesList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = pokemonNamesList.size

    inner class ViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
        private val pokemonTextView: TextView = itemView.findViewById(R.id.tv_pokemon_name)
        fun bind(item: Pokemon) {
            pokemonTextView.text = item.name
        }
    }

}