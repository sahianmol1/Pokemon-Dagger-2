package com.example.pokemondagger2.repositories

import com.example.pokemondagger2.data.response.PokemonResponse
import retrofit2.Response

interface PokemonRepository {
    suspend fun pokemonList(): Response<PokemonResponse>
}