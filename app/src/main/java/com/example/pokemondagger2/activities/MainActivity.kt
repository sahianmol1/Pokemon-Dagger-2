package com.example.pokemondagger2.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemondagger2.BaseApplication
import com.example.pokemondagger2.activities.adapter.PokemonAdapter
import com.example.pokemondagger2.databinding.ActivityMainBinding
import com.example.pokemondagger2.di.app.AppModule
import com.example.pokemondagger2.di.app.DaggerAppComponent
import com.example.pokemondagger2.viewmodels.PokemonViewModel
import com.example.pokemondagger2.viewmodels.PokemonViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: PokemonViewModelFactory
    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[PokemonViewModel::class.java]
        viewModel.getPokemonList()

        binding.rvPokemon.layoutManager = LinearLayoutManager(this)

        viewModel.pokemonList.observe(this) { pokemonList ->
            adapter = PokemonAdapter(pokemonList)
            binding.rvPokemon.adapter = adapter
        }
    }
}