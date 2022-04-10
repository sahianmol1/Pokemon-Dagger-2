package com.example.pokemondagger2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemondagger2.repositories.PokemonRepositoryImpl
import javax.inject.Inject
import javax.inject.Provider

class PokemonViewModelFactory @Inject constructor(private val pokemonRepositoryImpl: Provider<PokemonRepositoryImpl>): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(pokemonRepositoryImpl.get()) as T
    }
}