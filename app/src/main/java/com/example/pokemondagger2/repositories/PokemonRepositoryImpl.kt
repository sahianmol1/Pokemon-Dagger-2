package com.example.pokemondagger2.repositories

import com.example.pokemondagger2.data.PokemonApi
import com.example.pokemondagger2.data.response.PokemonResponse
import retrofit2.Response
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonApi: PokemonApi): PokemonRepository {
    override suspend fun pokemonList() = pokemonApi.getPokemonList()
}