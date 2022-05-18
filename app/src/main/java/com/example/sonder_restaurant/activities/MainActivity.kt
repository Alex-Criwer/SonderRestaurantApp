package com.example.sonder_restaurant.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.sonder_restaurant.R
import com.example.sonder_restaurant.helpers.FragmentClickListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity(), FragmentClickListener {
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        initView()
    }

    private fun initView() {
        navController = findNavController(R.id.fragmentNavView)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    override fun onOpenDetailMenuItemClickListener() {
        navController.navigate(R.id.detailFragment)
    }
}