package com.instances.postapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.instances.postapi.R
import com.instances.postapi.databinding.ActivityMainBinding
import com.instances.postapi.networking.ApiListener
import com.instances.postapi.networking.NetworkingModel
import com.instances.postapi.networking.request.LoginRequest
import com.instances.postapi.networking.response.Data
import com.instances.postapi.networking.response.LoginResponse
import com.instances.postapi.utils.PrefManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: PrefManager
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.apply {

        }
    }


    private fun initViews() {
        manager = PrefManager(this@MainActivity)
        bottomNavView = binding.bottomNavView
        setUpNavHost()

    }

    private fun setUpNavHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavView.setupWithNavController(navController)
    }


}