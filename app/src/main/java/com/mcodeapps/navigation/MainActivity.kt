package com.mcodeapps.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController
    private val TAG = "MainActivity"
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)

        nav_view.bringToFront()
        nav_view.setupWithNavController(navController)
        bottom_nav.setupWithNavController(navController)


        setupActionBarWithNavController(navController, appBarConfiguration)

        nav_view.setNavigationItemSelectedListener(this)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawer_layout.closeDrawers()
        return NavigationUI.onNavDestinationSelected(item,navController) || super.onOptionsItemSelected(item)
    }

}
