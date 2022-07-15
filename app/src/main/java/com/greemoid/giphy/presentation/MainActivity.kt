package com.greemoid.giphy.presentation

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.greemoid.giphy.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.gifsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        /*val actionBar = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)*/
    }
}