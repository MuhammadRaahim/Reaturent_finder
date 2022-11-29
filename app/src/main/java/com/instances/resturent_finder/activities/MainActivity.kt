package com.instances.resturent_finder.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.instances.resturent_finder.R
import com.instances.resturent_finder.databinding.ActivityMainBinding
import com.instances.resturent_finder.utils.PrefManager

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