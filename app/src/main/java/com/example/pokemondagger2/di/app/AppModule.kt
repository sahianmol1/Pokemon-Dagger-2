package com.example.pokemondagger2.di.app

import com.example.pokemondagger2.BaseApplication.Companion.BASE_URL
import com.example.pokemondagger2.data.PokemonApi
import com.example.pokemondagger2.repositories.PokemonRepository
import com.example.pokemondagger2.repositories.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun retrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Provides
        @Singleton
        fun pokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)
    }


    @Binds
    abstract fun pokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}