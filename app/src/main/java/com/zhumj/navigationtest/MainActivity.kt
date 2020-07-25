package com.zhumj.navigationtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)
//        toolbar.setupWithNavController(navController)

        Log.d("11111111111111", "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
        Log.d("11111111111111", "homeId = ${R.id.navigation_home}, /n dashboardId = ${R.id.navigation_dashboard}, /n notificationsId = ${R.id.navigation_notifications}")
        Log.d("11111111111111", "action_to_message id = ${R.id.action_to_message}, /n action_settings_to_top id = ${R.id.action_settings_to_top}")
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d("11111111111111", "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            Log.d("11111111111111", "label = ${destination.label}")
            Log.d("11111111111111", "id = ${destination.id}")
            val isTop = destination.id == R.id.navigation_home || destination.id == R.id.navigation_dashboard || destination.id == R.id.navigation_notifications
            if (isTop) {
                if (!bottomNavView.isVisible) {
                    bottomNavView.isVisible = true

                    val anim = AnimationUtils.loadAnimation(this, R.anim.pop_enter_anim)
                    bottomNavView.animation = anim
                }
            } else {
                if (bottomNavView.isVisible) {
                    bottomNavView.isVisible = false

                    val anim = AnimationUtils.loadAnimation(this, R.anim.exit_anim)
                    bottomNavView.animation = anim
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("111111111111111", "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
        Log.d("11111111111111111", "MainActivity onOptionsItemSelected")
        return super.onOptionsItemSelected(item)
    }
}
