package com.example.pokemondagger2.data.response

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")
    val pokemon: List<Pokemon>
)