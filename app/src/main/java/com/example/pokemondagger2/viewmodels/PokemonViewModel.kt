package com.example.pokemondagger2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemondagger2.data.response.Pokemon
import com.example.pokemondagger2.repositories.PokemonRepository
import com.example.pokemondagger2.repositories.PokemonRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val pokemonRepository: PokemonRepository): ViewModel() {
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList : LiveData<List<Pokemon>> get() = _pokemonList

    fun getPokemonList() = viewModelScope.launch {
        val response = pokemonRepository.pokemonList()
        if (response.body()!= null) {
            _pokemonList.value = response.body()!!.pokemon
        } else {
            RuntimeException("Something went Wrong")
        }
    }
}