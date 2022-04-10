package com.example.pokemondagger2

import android.app.Application
import com.example.pokemondagger2.di.app.AppComponent
import com.example.pokemondagger2.di.app.AppModule
import com.example.pokemondagger2.di.app.DaggerAppComponent

class BaseApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}