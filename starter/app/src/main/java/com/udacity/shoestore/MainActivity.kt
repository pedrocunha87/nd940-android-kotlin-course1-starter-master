package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        val binding =
            DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.NavigationHost) as NavHostFragment

        val navController = navHostFragment.navController

        navController.let {
            it.setGraph(R.navigation.navigation)

            val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.listFragment))

            setSupportActionBar(binding.toolbar)

            binding
                .toolbar
                .setupWithNavController(it, appBarConfiguration)
        }
    }
}
