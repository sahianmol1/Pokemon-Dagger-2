package com.example.pokemondagger2.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemondagger2.BaseApplication

open class BaseActivity: AppCompatActivity() {

    private val activityComponent get() = (application as BaseApplication).appComponent

    protected val injector get() = activityComponent
}