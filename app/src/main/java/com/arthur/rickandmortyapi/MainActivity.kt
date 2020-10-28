package com.arthur.rickandmortyapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.arthur.rickandmortyapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding? =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.bottomNav.setupWithNavController(
                Navigation.findNavController(this, R.id.nav_host_fragment))
    }
}